package com.example.javafx;

import com.example.minirpgjavafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartingController extends Game {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField numberHeroesTextField;
    @FXML
    Button numberHeroesButton;
    @FXML
    Label startingLabel;

    public int getNumber(){
        return this.nbreHeros;
    }

    public void pressingGO(ActionEvent gopress) throws IOException {

        try{


            int nbreHeros = Integer.parseInt(numberHeroesTextField.getText());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("choseheroes.fxml"));
            root = loader.load();
            ChoseHeroController choseHeroController = loader.getController();
            choseHeroController.choseHeroButtons(nbreHeros);

            stage = (Stage)((Node)gopress.getSource()).getScene().getWindow();
            scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

        }catch (NumberFormatException e){
            startingLabel.setText("Entrez un nombre s'il vous plaît");
        }




    }


}
