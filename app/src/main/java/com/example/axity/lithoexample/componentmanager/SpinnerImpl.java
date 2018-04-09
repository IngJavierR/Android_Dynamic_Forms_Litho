package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.mount.CustomButton;
import com.example.axity.lithoexample.mount.CustomSpinner;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.yoga.YogaEdge;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class SpinnerImpl implements  IComponentChain{

    private IComponentChain chain;

    @Override
    public void setNextChain(IComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {
        if(data.equals("3")){
            builder.child(
                CustomSpinner.create(c)
                .widthDip(120)
                .heightDip(48)
                .marginDip(YogaEdge.RIGHT, 16)
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
