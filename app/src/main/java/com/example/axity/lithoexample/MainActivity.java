package com.example.axity.lithoexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.axity.lithoexample.Flow.FirsScreen;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.yoga.YogaAlign;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext context = new ComponentContext(this);

        final Component component =
                FirsScreen.create(context)
                .alignSelf(YogaAlign.CENTER)
                .build();

        /*final Component component =
                RecyclerCollectionComponent.create(context)
                .disablePTR(true)
                .section(ListSection.create(new SectionContext(context)).build())
                .build();*/

        //setContentView(LithoView.create(context, component));

        setContentView(LithoView.create(context, component));
    }
}
