package com.example.axity.lithoexample.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javierrodriguez on 4/11/18.
 */

public class JsonManager {

    private String jsonString;
    private JSONObject jsonObject = null;

    public JsonManager(String jsonString) {
        this.jsonString = jsonString;
        jsonObject = new JSONObject();
    }

    public JsonManager parse() {
        try {
            this.jsonObject = new JSONObject(this.jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JSONArray getParents(){
        JSONArray arr = null;
        try {
            arr = this.jsonObject.getJSONArray("elements");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public String getChild(String propName){
        String value = "";
        try {
            value = this.jsonObject.getString(propName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public List<String> getChildArray(String propName){
        List<String> values = new ArrayList<>();
        try {
            JSONArray jsonArray = this.jsonObject.getJSONArray(propName);
            for(int i=0; i< jsonArray.length(); i++){
                values.add(jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static JSONArray getJsonArrayInsideArrayByIndex(JSONArray arr, int index){
        JSONArray jsonArrayChild = null;
        try {
            jsonArrayChild = arr.getJSONArray(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArrayChild;
    }

    public static JSONObject getJsonObjectInsideArrayByIndex(JSONArray arr, int index){
        JSONObject jsonObject = null;
        try {
            jsonObject = arr.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
