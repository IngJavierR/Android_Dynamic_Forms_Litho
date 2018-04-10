package com.example.axity.lithoexample.Flow;

import com.example.axity.lithoexample.componentmanager.ButtonImpl;
import com.example.axity.lithoexample.componentmanager.CaptureTextImpl;
import com.example.axity.lithoexample.componentmanager.IComponentChain;
import com.example.axity.lithoexample.componentmanager.ShowTextImpl;
import com.example.axity.lithoexample.componentmanager.SpinnerImpl;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaWrap;

import static com.facebook.yoga.YogaAlign.CENTER;

/**
 * Created by javierrodriguez on 4/6/18.
 */
@LayoutSpec
public class FirsScreenSpec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c) {

        IComponentChain c1 = new CaptureTextImpl();
        IComponentChain c2 = new ShowTextImpl();
        IComponentChain c3 = new ButtonImpl();
        IComponentChain c4 = new SpinnerImpl();
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);

        Column.Builder columnParentBuild = Column.create(c);

        Row.Builder rowParentBuild;
        Column.Builder columnChildBuild;

        for(int i=0; i<2; i++){
            rowParentBuild = Row.create(c);
            for(int y=0; y<4; y++){
                columnChildBuild = Column.create(c);
                c1.dispense(c, columnChildBuild, String.valueOf(y));
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
