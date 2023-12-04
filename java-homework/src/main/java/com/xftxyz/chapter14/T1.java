package com.xftxyz.chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T1 extends Application {
    // http://liveexample.pearsoncmg.com/resource/image.zip
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(10);
        pane.setVgap(10);
        ImageView imageView1 = new ImageView("image/flag1.gif");
        ImageView imageView2 = new ImageView("image/flag5.gif");
        ImageView imageView3 = new ImageView("image/flag6.gif");

        pane.add(imageView1, 0, 0);
        pane.add(imageView2, 0, 1);
        pane.add(imageView3, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class T1Bootstrap {
    public static void main(String[] args) {
        Application.launch(T1.class, args);
    }
}