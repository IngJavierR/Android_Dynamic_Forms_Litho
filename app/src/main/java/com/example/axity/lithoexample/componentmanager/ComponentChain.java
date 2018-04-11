package com.example.axity.lithoexample.componentmanager;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public abstract class ComponentChain {

    public abstract void setNextChain(ComponentChain nextChain);

    public abstract void dispense(ComponentContext c, Column.Builder builder, String data);

    public interface OnEventListener {
        void onEventChange(ComponentContext c, String id, String type, String text, int position);
    }
}
