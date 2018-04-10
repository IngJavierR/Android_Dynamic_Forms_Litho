package com.example.axity.lithoexample.components;

import android.widget.Toast;

import com.example.axity.lithoexample.mount.CustomSpinner;
import com.example.axity.lithoexample.mount.CustomSpinnerSpec;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;

import java.util.List;

/**
 * Created by javierrodriguez on 4/6/18.
 */

@LayoutSpec
public class SpinnerComponentSpec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String id,
            @Prop List<String> dataList) {
        return CustomSpinner.create(c)
                .dataList(dataList)
                .identifier(id)
                .listener(new CustomSpinnerSpec.OnSelectedChangeListener() {
                    @Override
                    public void onSelectedChange(ComponentContext c, String identifier, int position) {
                        Toast.makeText(c, "Position - " + position + " Id- " + identifier, Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
