package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ChoseHeroController extends StartingController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String type;


    @FXML
    Button heroButtonW;
    @FXML
    Button heroButtonM;
    @FXML
    Button heroButtonH;
    @FXML
    Label labelChoseHeroes;
    @FXML
    Button adventureButton;

    public void choseHeroButtons(int nbreHeros){

        this.nbreHeros = nbreHeros;
        statusLabel(nbreHeros);

    }

    public void statusLabel(int nbreHeros){
        if (nbreHeros > 0){
            labelChoseHeroes.setText("Vous devez choisir encore : "+nbreHeros+" héros");
        } else {
            labelChoseHeroes.setText("Bravo vous pouvez commencer l'aventure !");
            adventureButton.setVisible(true);

        }

    }

    public void startadventure(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("adventure.fxml"));
        root = loader.load();

        AdventureController adventureController = loader.getController();
        adventureController.getHeroList(listeHerosGame);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();

    }


    public void pressH(ActionEvent e){
        this.nbreHeros = nbreHeros-1;
        statusLabel(nbreHeros);
        choseHerosGUI("Hunter");

    }

    public void pressW(ActionEvent e){
        this.nbreHeros = nbreHeros-1;
        statusLabel(nbreHeros);
        choseHerosGUI("Warrior");

    }

    public void pressM(ActionEvent e){
        this.nbreHeros = nbreHeros-1;
        statusLabel(nbreHeros);
        choseHerosGUI("Mage");

    }

}
