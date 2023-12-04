package com.xftxyz.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox pane = new HBox(5);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52 };
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(list);

        ImageView p1 = new ImageView("image/card/" + Integer.valueOf(list.get(0)) + ".png");
        ImageView p2 = new ImageView("image/card/" + Integer.valueOf(list.get(1)) + ".png");
        ImageView p3 = new ImageView("image/card/" + Integer.valueOf(list.get(2)) + ".png");
        pane.getChildren().addAll(p1, p2, p3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercose14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

class T3Bootstrap {
    public static void main(String[] args) {
        Application.launch(T3.class, args);
    }
}