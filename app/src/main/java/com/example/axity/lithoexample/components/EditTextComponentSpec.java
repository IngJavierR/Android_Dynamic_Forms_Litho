package com.example.axity.lithoexample.components;

import android.widget.Toast;

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
public class EditTextComponentSpec {
    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String id) {
        return Column.create(c)
                .child(Text.create(c)
                        .text("Apellido paterno")
                        .textSizeSp(15))
                .child(EditText.create(c)
                        .hint("Apellido paterno")
                        .textChangedEventHandler(EditTextComponent.onChangeText(c)))
                .build();
    }

    @OnEvent(TextChangedEvent.class)
    static void onChangeText(ComponentContext c, @FromEvent String text, @Prop String id){
        Toast.makeText(c, text + " - " + id, Toast.LENGTH_SHORT).show();
    }


}
