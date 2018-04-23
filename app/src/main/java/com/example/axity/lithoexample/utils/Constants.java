package com.example.axity.lithoexample.utils;

/**
 * Created by javierrodriguez on 4/11/18.
 */

public class Constants {

    public static final String CHAIN_EDITTEXT = "EditText";
    public static final String CHAIN_BUTTON = "Button";
    public static final String CHAIN_SPINNER = "Spinner";

    public static final String ELEMENTS = "elements";
    public static final String ELEMENTS_TYPE = "type";
    public static final String ELEMENTS_OPTIONS = "options";
    public static final String ELEMENTS_ID = "id";
    public static final String ELEMENTS_HINT = "hint";
    public static final String ELEMENTS_STYLE = "style";
    public static final String ELEMENTS_STYLE_LABE = "styleLabel";


    public static final String REGEX_REPLACE_IN_JSON = "(id\": \"%s\"[\\s\\S\\w\\d]+?\"value\": )(\".*?\")";
    public static final String REGEX_REPLACE_IN_JSON_FORMAT = "$1\"%s\"";
}
