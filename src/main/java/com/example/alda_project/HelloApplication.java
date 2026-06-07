package com.example.alda_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        GameManager gameManager = new GameManager();
        gameManager.StartGame();
        //System.out.println(gameManager.map.findRoomMiddlepoint(gameManager.map.rooms.get(0)));


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W -> gameManager.playerMove(Direction.UP);
                case A -> gameManager.playerMove(Direction.LEFT);
                case S -> gameManager.playerMove(Direction.DOWN);
                case D -> gameManager.playerMove(Direction.RIGHT);
            }
        });


    }
}
