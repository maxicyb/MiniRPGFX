package com.example.minirpgjavafx;

import java.util.Random;

public class BasicEnemy extends Enemy {

    private int maxAtk;
    private int chosenAtk;
    private int chosenHP;

    public BasicEnemy() {
        Scream();
        System.out.println("Cet ennemi est basique");
        Random rand = new Random();
        maxLifePointsE=50;
        maxAtk=20;
        chosenAtk=rand.nextInt(maxAtk)+1;
        chosenHP=rand.nextInt(maxLifePointsE)+1;

        this.lifePointsE = chosenHP;
        this.weaponDamageE = chosenAtk;

        System.out.println("Cet ennemi possède : "+chosenAtk+" Atk / "+chosenHP+"/"+maxLifePointsE+" Hp");

    }

    public void Scream(){


        System.out.println(
                "************************************************************\n"+
                "       /       \\\n" +
                "   __ /   .-.  .\\\n" +
                "  /  `\\  /   \\/  \\\n" +
                "  |  _ \\/   .==.==.\n" +
                "  | (   \\  /____\\__\\\n" +
                "   \\ \\      (_()(_()\n" +
                "    \\ \\            '---._\n" +
                "     \\                   \\_\n" +
                "  /\\ |`       (__)________/\n" +
                " /  \\|     /\\___/\n" +
                "|    \\     \\VVVV\n" +
                "|     \\     \\"




             );
    }


}
