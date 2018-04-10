package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.EditTextComponent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.widget.EditText;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class ShowTextImpl implements  IComponentChain{

    private IComponentChain chain;

    @Override
    public void setNextChain(IComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {
        if(data.equals("2")){
            builder.child(
                EditTextComponent.create(c)
                .id("Var1")
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
