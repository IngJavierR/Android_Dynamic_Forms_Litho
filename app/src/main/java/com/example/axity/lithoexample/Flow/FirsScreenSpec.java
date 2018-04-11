package com.example.axity.lithoexample.Flow;

import com.example.axity.lithoexample.componentmanager.ButtonImpl;
import com.example.axity.lithoexample.componentmanager.EditTextImpl;
import com.example.axity.lithoexample.componentmanager.IComponentChain;
import com.example.axity.lithoexample.componentmanager.SpinnerImpl;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaWrap;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.facebook.yoga.YogaAlign.CENTER;

/**
 * Created by javierrodriguez on 4/6/18.
 */
@LayoutSpec
public class FirsScreenSpec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop JSONArray jsonArray) {

        IComponentChain c1 = new EditTextImpl();
        IComponentChain c2 = new ButtonImpl();
        IComponentChain c3 = new SpinnerImpl();
        c1.setNextChain(c2);
        c2.setNextChain(c3);

        Column.Builder columnParentBuild = Column.create(c);
        Row.Builder rowParentBuild;
        Column.Builder columnChildBuild;

        for(int i=0; i<jsonArray.length(); i++){
            rowParentBuild = Row.create(c);

            JSONArray jsonArrayChild = JsonManager
                    .getJsonArrayInsideArrayByIndex(jsonArray, i);

            for(int y=0; y<jsonArrayChild.length(); y++){
                columnChildBuild = Column.create(c);

                JSONObject jsonObjectChild = JsonManager
                        .getJsonObjectInsideArrayByIndex(jsonArrayChild, y);

                c1.dispense(c, columnChildBuild, jsonObjectChild.toString());

                rowParentBuild.child(columnChildBuild);
            }
            columnParentBuild.child(rowParentBuild);
        }

        return columnParentBuild
                .alignItems(CENTER)
                .justifyContent(YogaJustify.CENTER)
                .alignContent(CENTER)
                .alignItems(CENTER)
                .wrap(YogaWrap.WRAP)
                .build();

    }
}
