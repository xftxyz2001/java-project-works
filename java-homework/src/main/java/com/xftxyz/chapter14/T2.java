package com.xftxyz.chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(8, 8, 8, 8));
        pane.setHgap(8);
        pane.setVgap(8);

        for (int column = 0; column < 3; column++)
            for (int row = 0; row < 3; row++) {
                int i = (int) (Math.random() * 3);
                if (i != 2)
                    pane.add(getNode(i), column, row);
            }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ImageView getNode(int i) {
        if (i == 0)
            return new ImageView("image/o.gif");
        else
            return new ImageView("image/x.gif");
    }
}

class T2Bootstrap {
    public static void main(String[] args) {
        Application.launch(T2.class, args);
    }
}