package com.example.minirpgjavafx;

import java.util.Random;

public class BossEnemy extends Enemy {

    private int maxAtk;
    private int chosenAtk;
    private int chosenHP;

    public BossEnemy() {
        Scream();
        System.out.println("Cet ennemi est un boss");
        Random rand = new Random();
        maxLifePointsE=1000;
        maxAtk=300;
        chosenAtk=rand.nextInt(maxAtk)+1;
        chosenHP=rand.nextInt(maxLifePointsE)+1;

        this.lifePointsE = chosenHP;
        this.weaponDamageE = chosenAtk;

        System.out.println("Cet ennemi possède : "+chosenAtk+" Atk / "+chosenHP+"/"+maxLifePointsE+" Hp");

    }

    public void Scream(){


        System.out.println( "HAHAHAHAHAHHAHAHAHAHAHHAHAHAHHA");
    }


}
