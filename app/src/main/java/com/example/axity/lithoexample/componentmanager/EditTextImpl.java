package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.EditTextComponent;
import com.example.axity.lithoexample.components.EditTextComponentSpec;
import com.example.axity.lithoexample.utils.Constants;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class EditTextImpl extends ComponentChain {

    private ComponentChain chain;
    private EditTextImpl.OnEventListener listener;

    public EditTextImpl(EditTextImpl.OnEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void setNextChain(ComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {

        JsonManager manager = new JsonManager(data).parse();

        if(manager.getChild(Constants.ELEMENTS_TYPE).equals(Constants.CHAIN_EDITTEXT)){
            builder.child(
                EditTextComponent.create(c)
                .id(manager.getChild(Constants.ELEMENTS_ID))
                .hint(manager.getChild(Constants.ELEMENTS_HINT))
                .title(manager.getChild(Constants.ELEMENTS_HINT))
                .listener(new EditTextComponentSpec.OnChangeTextListener() {
                    @Override
                    public void onChangeText(ComponentContext c, String text, String id) {
                        EditTextImpl.this.listener.onEventChange(c, id, Constants.CHAIN_EDITTEXT, text, 0);
                    }
                })
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }

}
