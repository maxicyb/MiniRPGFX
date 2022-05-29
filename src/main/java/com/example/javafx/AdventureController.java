package com.example.javafx;
import javafx.event.ActionEvent;
import com.example.minirpgjavafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;


public class AdventureController extends Game {
    @FXML
    Button attackBtn;
    @FXML
    Button defBtn;
    @FXML
    Button consumableBtn;
    @FXML
    ProgressBar hpBarHero;
    @FXML
    ProgressBar hpBarEnemy;
    @FXML
    Label actionHeroDisplayerLabel;
    @FXML
    Label actionEnemyDisplayerLabel;
    @FXML
    Label heroStatDisplayerLabel;
    @FXML
    Label monsterStatDisplayerLabel;
    @FXML
    ImageView heroImageView;

    public void getHeroList(List<Hero> listeHerosGame){
        //adventureGUI(listeHerosGame);
        System.out.println(listeHerosGame);

    }


    public void attackButton(ActionEvent atkEvent){
        displayEnemyHp();
        displayHeroHp();
        actionHeroDisplayerLabel.setText("Vous attaquez l'ennemi avec : ");
        
        
    }

    public void defendButton(ActionEvent defEvent){

        System.out.println("Test de passage dans la défense");
    }

    public void consumableButton(ActionEvent conEvent){

    }

    public void displayHeroHp(){
        Hero hero = listeHerosGame.get(listeHerosGame.size()-1);
        hpBarEnemy.setProgress(hero.getLifePoints()/200);

    }

    public void displayEnemyHp(){
        Enemy enemy = listeEnemyGame.get(listeEnemyGame.size() - 1);

        hpBarEnemy.setProgress(enemy.getLifePointsE()/50);

    }

}
