package com.example.axity.lithoexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.axity.lithoexample.Flow.FirsScreen;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.yoga.YogaAlign;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LithoView lithoView = findViewById(R.id.lithoComponent);

        String json = "{ \n" +
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
                "\t            \"maxCharacters\": 100\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Apellido_Materno\",\n" +
                "\t            \"type\": \"EditText\",\n" +
                "\t            \"inputType\": \"STRING\",\n" +
                "\t            \"hint\": \"Apellido Materno\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"minCharacters\": 0,\n" +
                "\t            \"maxCharacters\": 100\n" +
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
                "\t            \"maxCharacters\": 100\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Fecha_Nac_Dia\",\n" +
                "\t            \"type\": \"Spinner\",\n" +
                "\t            \"inputType\": \"\",\n" +
                "\t            \"hint\": \"\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"options\": [\"Enero\", \"Febrero\"],\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100\n" +
                "\t        },\n" +
                "\t        {\n" +
                "\t            \"id\": \"Fecha_Nac_Mes\",\n" +
                "\t            \"type\": \"Spinner\",\n" +
                "\t            \"inputType\": \"\",\n" +
                "\t            \"hint\": \"\",\n" +
                "\t            \"regex\":\"\",\n" +
                "\t            \"required\":false,\n" +
                "\t            \"options\": [\"1\", \"2\"],\n" +
                "\t            \"minCharacters\": 10,\n" +
                "\t            \"maxCharacters\": 100\n" +
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
                "\t            \"maxCharacters\": 100\n" +
                "\t        }\n" +
                "\t    ]\n" +
                "\t]\n" +
                "}";

        JSONArray parents =
                new JsonManager(json)
                    .parse()
                    .getParents();

        final ComponentContext context = new ComponentContext(this);
        final Component component =
                FirsScreen.create(context)
                .jsonArray(parents)
                .alignSelf(YogaAlign.CENTER)
                .build();

        lithoView.setComponent(component);
    }
}
