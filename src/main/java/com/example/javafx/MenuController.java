package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void startgame(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("starting.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();

    }
}
