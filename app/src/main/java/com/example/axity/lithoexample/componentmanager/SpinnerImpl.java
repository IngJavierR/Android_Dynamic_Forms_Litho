package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.SpinnerComponent;
import com.example.axity.lithoexample.components.SpinnerComponentSpec;
import com.example.axity.lithoexample.utils.Constants;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.yoga.YogaEdge;

import java.util.List;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class SpinnerImpl extends ComponentChain {

    private ComponentChain chain;
    private SpinnerImpl.OnEventListener listener;

    public SpinnerImpl(OnEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void setNextChain(ComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {

        JsonManager manager = new JsonManager(data).parse();

        if(manager.getChild(Constants.ELEMENTS_TYPE).equals(Constants.CHAIN_SPINNER)){

            List<String> dataList = manager.getChildArray(Constants.ELEMENTS_OPTIONS);

            builder.child(
                SpinnerComponent.create(c)
                .id(manager.getChild(Constants.ELEMENTS_ID))
                .dataList(dataList)
                .listener(new SpinnerComponentSpec.OnChangeSelectListener() {
                    @Override
                    public void onChangeSelect(ComponentContext c, int position, String id) {
                        SpinnerImpl.this.listener.onEventChange(c, id, Constants.CHAIN_SPINNER, "", position);
                    }
                })
                .widthDip(120)
                .heightDip(48)
                .marginDip(YogaEdge.RIGHT, 16)
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
