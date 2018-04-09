package com.example.axity.lithoexample.mount;

import android.widget.Button;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;

/**
 * Created by javierrodriguez on 4/9/18.
 */
@MountSpec
public class CustomButtonSpec {

    @OnCreateMountContent
    static Button onCreateMountContent(ComponentContext c){
        return new Button(c);
    }

    @OnMount
    static void onMount(ComponentContext c, Button button, @Prop String text){
        button.setText(text);
    }
}
