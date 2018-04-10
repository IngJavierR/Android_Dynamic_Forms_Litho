package com.example.axity.lithoexample.components;

import android.widget.Toast;

import com.example.axity.lithoexample.mount.CustomButton;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.EditText;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.TextChangedEvent;

/**
 * Created by javierrodriguez on 4/6/18.
 */

@LayoutSpec
public class ButtonComponentSpec {
    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String id) {
        return CustomButton.create(c)
                .text("CLick Me!")
                .clickHandler(ButtonComponent.onButtonClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onButtonClick(ComponentContext c, @Prop String id){
        Toast.makeText(c, "Click - " + id, Toast.LENGTH_SHORT).show();
    }
}
