package com.example.minirpgjavafx;

import java.util.List;
import java.util.Scanner;

public class Warrior extends Hero {


    public Warrior(int pv, int maxPV, int armure, int degats) {
        super(pv, maxPV, armure, degats);
    }

    public Warrior(int pv, int maxPV, int armure, int degats, List<Food> foods) {
        super(pv, maxPV, armure, degats, foods);
    }

    @Override
    public boolean attack() {
        System.out.println("Le warrior attaque");
        return true;
    }

    @Override
    public void reward(Scanner scanner) {
        System.out.println("1. Augmenter votre armure");
        System.out.println("2. Augmenter les PVs Max");
        System.out.println("3. Augmenter dégats de votre arme");
        System.out.println("4. Ajouter de la nourriture à votre inventaire");
        System.out.print(">");
        int Choice = scanner.nextInt();

        switch (Choice) {

            case 1:
                this.armor = getArmor() + 1;
                System.out.println("Vous augmentez votre armure d'un point");
                break;

            case 2:
                this.maxPV = getMaxPV() + 10;
                System.out.println("Vous augmentez de 10 vos PVs Max");
                break;

            case 3:
                this.weaponDamage = getWeaponDamage() + 5;
                System.out.println("Vous augmentez de 5 les dégats de votre arme");
                break;

            case 4:
                this.getListeFoodGame().add(new Food());
                System.out.println("Vous ajoutez de la nourriture à votre stock, vous avez : "+ getListeFoodGame().size() + " dans votre stock");
                break;

        }


    }
}
