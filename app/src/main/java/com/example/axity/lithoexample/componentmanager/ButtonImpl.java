package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.CaptureText;
import com.example.axity.lithoexample.mount.CustomButton;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.yoga.YogaEdge;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class ButtonImpl implements  IComponentChain{

    private IComponentChain chain;

    @Override
    public void setNextChain(IComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {
        if(data.equals("0")){
            builder.child(
                CustomButton.create(c)
                .text("Click Me!")
                .widthDip(100)
                .heightDip(48)
                .marginDip(YogaEdge.RIGHT, 16)
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
