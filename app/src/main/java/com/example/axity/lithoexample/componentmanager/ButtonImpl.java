package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.ButtonComponent;
import com.example.axity.lithoexample.components.ButtonComponentSpec;
import com.example.axity.lithoexample.utils.Constants;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.yoga.YogaEdge;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class ButtonImpl extends ComponentChain {

    private ComponentChain chain;
    private ButtonImpl.OnEventListener listener;

    public ButtonImpl(OnEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void setNextChain(ComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {

        JsonManager manager = new JsonManager(data).parse();

        if(manager.getChild(Constants.ELEMENTS_TYPE).equals(Constants.CHAIN_BUTTON)){
            builder.child(
                ButtonComponent.create(c)
                .id(manager.getChild(Constants.ELEMENTS_ID))
                .text(manager.getChild(Constants.ELEMENTS_HINT))
                .style(manager.getChild(Constants.ELEMENTS_STYLE))
                .listener(new ButtonComponentSpec.OnChangeClickListener() {
                    @Override
                    public void onClick(ComponentContext c, String id) {
                        ButtonImpl.this.listener.onEventChange(c, id, Constants.CHAIN_BUTTON, "", 0);
                    }
                })
                .widthDip(100)
                .heightDip(48)
                .marginDip(YogaEdge.RIGHT, 16)
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
