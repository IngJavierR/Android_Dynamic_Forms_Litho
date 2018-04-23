package com.example.axity.lithoexample.components;

import com.example.axity.lithoexample.mount.CustomButton;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;

/**
 * Created by javierrodriguez on 4/6/18.
 */

@LayoutSpec
public class ButtonComponentSpec {
    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String id,
            @Prop String text,
            @Prop (
                    resType = ResType.NONE,
                    optional = true
            )  String style) {

        String estilo = (style == null || "".equals(style) ? "StyleButtonDefault" : style);
        int resourceId = c.getResources().getIdentifier(estilo,"style",c.getPackageName());
        return CustomButton.create(c,0,resourceId)
                .text(text)
                .clickHandler(ButtonComponent.onButtonClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onButtonClick(ComponentContext c,
              @Prop String id,
              @Prop ButtonComponentSpec.OnChangeClickListener listener){
        listener.onClick(c, id);
    }

    public interface OnChangeClickListener {
        void onClick(ComponentContext c, String id);
    }
}
