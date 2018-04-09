package com.example.axity.lithoexample.layoutspecs;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;

import static com.facebook.yoga.YogaEdge.ALL;

/**
 * Created by javierrodriguez on 4/6/18.
 */

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop int color,
            @Prop String title,
            @Prop String subTitle){

        return Column.create(c)
                .paddingDip(ALL, 16)
                .backgroundColor(color)
                .child(
                    Text.create(c)
                    .text(title)
                    .textSizeDip(40))
                .child(
                    Text.create(c)
                    .text(subTitle)
                    .textSizeDip(20))
                .build();
    }
}
