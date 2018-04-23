package com.example.axity.lithoexample.components;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;

import com.example.axity.lithoexample.R;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Output;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnLoadStyle;
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
                            .child(Text.create(c,0,resourceIdLabel)
                                    .text(title)
                                    //.textStyle(Typeface.BOLD)
                                    .textSizeSp(15))
                            .child(EditText.create(c,0,resourceId)
                                    .hint(hint)
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
/*
    @OnLoadStyle
    public static void onLoadStyle(
            ComponentContext c,
            Output<Integer> colorText1,
            Output<String> mensaje) {

        System.out.println("Saludos");

        int[] attributos = new int[] {R.attr.colorText1, R.attr.mensaje};
        final TypedArray a;
        a = c.obtainStyledAttributes (R.style.SomeStyle, attributos);
        //a = c.obtainStyledAttributes (attributos);
        for (int i = 0, size = a.getIndexCount(); i < size; i++) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.StyleEditTextComponent_colorText1) {
                colorText1.set(a.getInteger(attr, 0)  );
            }else if (attr == R.styleable.StyleEditTextComponent_mensaje) {
                mensaje.set( a.getString(attr));
            }


        }

        a.recycle();

    }
*/

}
