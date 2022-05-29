package com.example.minirpgjavafx;

import java.util.List;
import java.util.Scanner;

public class Mage extends Spellcaster {

    public Mage(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed) {
        this(pv, pvMax, armure, degats, manaPoints, maxManaPoints, manaUsed, null);
    }

    public Mage(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed, List<Food> foods) {
        this(pv, pvMax, armure, degats, manaPoints, maxManaPoints, manaUsed, foods, null);
    }

    public Mage(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed, List<Food> foods, List<Potion> potions) {
        super(pv, pvMax, armure, degats, manaPoints, maxManaPoints, manaUsed, foods, potions);
        this.manaPoints = manaPoints;
        this.maxManaPoints = maxManaPoints;
        this.manaUsed = manaUsed;
    }

    public int getManaUsed() {
        return manaUsed;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }


    @Override
    public boolean attack() {
        if (this.manaPoints - this.manaUsed < 0) {
            System.out.println("Le mage n'a plus de mana, il ne peut pas attaquer !!!");
            return false;
        } else {
            this.manaPoints = this.manaPoints - this.manaUsed;
            System.out.println("Le mage lance un sort " + this.manaPoints + "/" + this.maxManaPoints + " MANA disponible");
            return true;
        }
    }

    @Override
    public void reward(Scanner scanner) {
        System.out.println("1. Augmenter votre armure");
        System.out.println("2. Augmenter les PVs Max");
        System.out.println("3. Augmenter dégats de votre arme");
        System.out.println("4. Ajouter une potion de mana à votre stock");
        System.out.println("5. Ajouter de la nourriture à votre stock");
        System.out.println("6. Augmenter votre max de mana");
        System.out.println("7. Réduire le coût en mana des sorts");
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
                this.getListePotionsGame().add(new Potion());
                System.out.println("Vous ajoutez une potion à votre stock, vous avez : "+ getListePotionsGame().size() + " dans votre stock");
                break;

            case 5:
                this.getListeFoodGame().add(new Food());
                System.out.println("Vous ajoutez de la nourriture à votre stock, vous avez : "+ getListeFoodGame().size() + " dans votre stock");
                break;
            case 6:
                this.maxManaPoints = getMaxManaPoints() + 10;
                System.out.println("Vous augmentez votre mana max de 10");
                break;

            case 7:
                this.manaUsed = getManaUsed() - 1;
                System.out.println("Vous réduisez le coût en mana de vos sorts d'1 point");
                break;

        }


    }
}
