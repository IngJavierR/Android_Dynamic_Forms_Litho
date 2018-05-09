package com.example.axity.lithoexample.mount;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;

import java.util.List;

/**
 * Created by javierrodriguez on 4/9/18.
 */
@MountSpec
public class CustomSpinnerSpec {

    @OnCreateMountContent
    static Spinner onCreateMountContent(ComponentContext c){

        return new Spinner(c);
    }

    @OnMount
    static void onMount(final ComponentContext c,
                        Spinner spinner,
                        final @Prop String identifier,
                        @Prop List<String> dataList,
                        @Prop int value,
                        @Prop final OnSelectedChangeListener listener) {
        ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, dataList);

        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setSelection(value);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listener.onSelectedChange(c, identifier, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public interface OnSelectedChangeListener{
        void onSelectedChange(ComponentContext c, String identifier, int position);
    }


}
