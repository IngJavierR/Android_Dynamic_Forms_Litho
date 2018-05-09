package com.example.axity.lithoexample.components;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;
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
            @Prop String title,
            @Prop String hint,
            @Prop String value,
            @Prop int layout_weight,
            @Prop (
                    resType = ResType.NONE,
                    optional = true
            )  String style,
            @Prop (
               resType = ResType.NONE,
               optional = true
            ) String styleLabel,
            @Prop EditTextComponentSpec.OnChangeTextListener listener) {

       String estilo = (style == null || "".equals(style) ? "StyleEditTextDefault" : style);
       int resourceId = c.getResources().getIdentifier(estilo,"style",c.getPackageName());
        String estiloLabel = (styleLabel == null || "".equals(styleLabel) ? "StyleEditTextLabelDefault" : styleLabel);
        int resourceIdLabel = c.getResources().getIdentifier(estiloLabel,"style",c.getPackageName());

        Column.Builder result =  Column.create(c)
                            .flex(layout_weight)
                            //.flexGrow(layout_weight)
                            .child(Text.create(c,0,resourceIdLabel)
                                    .text(title))
                            .child(EditText.create(c,0,resourceId)
                                    .hint(hint)
                                    .text(value)
                                    .textChangedEventHandler(EditTextComponent.onChangeText(c)));

        return result.build();
    }

    @OnEvent(TextChangedEvent.class)
    static void onChangeText(ComponentContext c,
             @FromEvent String text,
             @Prop String id,
             @Prop EditTextComponentSpec.OnChangeTextListener listener){
        listener.onChangeText(c, text, id);
    }

    public interface OnChangeTextListener {
        void onChangeText(ComponentContext c, String text, String id);
    }

}
