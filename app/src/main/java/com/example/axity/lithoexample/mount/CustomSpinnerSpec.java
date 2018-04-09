package com.example.axity.lithoexample.mount;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;

import java.util.ArrayList;
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
    static void onMount(ComponentContext c, Spinner spinner){
        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Uno");
        spinnerArray.add("Dos");
        spinnerArray.add("Tres");

        ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}
