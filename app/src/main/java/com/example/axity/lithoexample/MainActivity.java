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
        setContentView(R.layout.activity_main);

        LithoView lithoView = findViewById(R.id.lithoComponent);

        final ComponentContext context = new ComponentContext(this);
        final Component component =
                FirsScreen.create(context)
                .alignSelf(YogaAlign.CENTER)
                .build();

        lithoView.setComponent(component);
    }
}
