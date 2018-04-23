package com.example.axity.lithoexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.axity.lithoexample.Flow.FirsScreen;
import com.example.axity.lithoexample.Flow.FirsScreenSpec;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.yoga.YogaAlign;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements FirsScreenSpec.EventHandlerListener{

    private final String TAG = this.getClass().getName();
    private String json = "";
    LithoView lithoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lithoView = findViewById(R.id.lithoComponent);

        this.json = "{ \n" +
                "\t\"elements\": [\n" +
                "\t\t[\n" +
                "\t        {\n" +
                "\t            \"id\": \"Apellido_Paterno\",\n" +
                "\t            \"type\": \"EditText\",\n" +
                "\t            \"inputType\": \"STRING\",\n" +
                "\t            \"hint\": \"Apellido Paterno\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"minCharacters\": 0,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"value\": \"\"\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Apellido_Materno\",\n" +
                "\t            \"type\": \"EditText\",\n" +
                "\t            \"inputType\": \"STRING\",\n" +
                "\t            \"hint\": \"Apellido Materno\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"minCharacters\": 0,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"style\": \"StyleEditTextDefault\",\n" +
                "\t            \"value\": \"\"\n" +
                "\t        }\n" +
                "\t    ],\n" +
                "\t    [\n" +
                "\t        {\n" +
                "\t            \"id\": \"Nombre\",\n" +
                "\t            \"type\": \"EditText\",\n" +
                "\t            \"inputType\": \"STRING\",\n" +
                "\t            \"hint\": \"Nombre(s)\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"value\": \"\"\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Fecha_Nac_Dia\",\n" +
                "\t            \"type\": \"Spinner\",\n" +
                "\t            \"inputType\": \"\",\n" +
                "\t            \"hint\": \"\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"options\": [\"1\", \"2\"],\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"style\": \"StyleSpinnerDefault\",\n" +
                "\t            \"value\": \"\"\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Fecha_Nac_Mes\",\n" +
                "\t            \"type\": \"Spinner\",\n" +
                "\t            \"inputType\": \"\",\n" +
                "\t            \"hint\": \"\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"options\": [\"Enero\", \"Febrero\"],\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"style\": \"StyleSpinnerDefault\",\n" +
                "\t            \"value\": \"\"\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Fecha_Nac_Anio\",\n" +
                "\t            \"type\": \"Spinner\",\n" +
                "\t            \"inputType\": \"\",\n" +
                "\t            \"hint\": \"\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"options\": [\"2000\", \"2001\"],\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100,\n" +
                "\t            \"style\": \"StyleSpinnerDefault\",\n" +
                "\t            \"value\": \"\"\n" +
                "\t        }\n" +
                "\t    ]\n" +
                "\t]\n" +
                "}";

        createJsonComponent(json);
    }

    private void createJsonComponent(String json){
        final ComponentContext context = new ComponentContext(this);
        final Component component =
                FirsScreen.create(context)
                        .jsonInput(json)
                        .alignSelf(YogaAlign.CENTER)
                        .listener(this)
                        .build();

        lithoView.setComponent(component);
    }

    @Override
    public void onEvent(ComponentContext c, String id, String type, String text, int position) {
        Log.i(TAG,String.format(Locale.ENGLISH,
                "Id: %s - Type: %s - Text: %s - Pos: %d", id, type, text, position));
        this.json = JsonManager.replaceInJsonTree(this.json, id, text);
    }
}
