package com.example.axity.lithoexample.componentmanager;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public interface IComponentChain {

    void setNextChain(IComponentChain nextChain);

    void dispense(ComponentContext c, Column.Builder builder, String data);
}
