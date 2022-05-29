package com.example.minirpgjavafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Hero {

    protected double lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected int maxPV;
    protected List<Potion> listePotionsGame;
    protected List<Food> listeFoodGame;

    public Hero(int pv, int pvMax, int armure, int degats) {
        this(pv, pvMax, armure, degats, null, null);
    }

    public Hero(int pv, int pvMax, int armure, int degats, List<Food> foods) {
        this(pv, pvMax, armure, degats, foods, null);
    }

    public Hero(int pv, int pvMax, int armure, int degats, List<Food> foods, List<Potion> potions) {
        this.lifePoints = pv;
        this.armor = armure;
        this.weaponDamage = degats;
        this.maxPV = pvMax;
        if (foods != null) {
            this.listeFoodGame = new ArrayList<>(); //Initialiser la liste dans le constructeur pour éviter les bugs
            this.listeFoodGame.addAll(foods);
        }
        if (potions != null) {
            this.listePotionsGame = new ArrayList<>();
            this.listePotionsGame.addAll(potions);
        }
    }


    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public int getMaxPV() {
        return maxPV;
    }

    public int getArmor() {
        return armor;
    }


    public abstract boolean attack();

    public abstract void reward(Scanner scanner);

    public void useConsumable(Consumable consumable) {
        System.out.println("Vous consommez un(e) " + consumable.nom());
        if (consumable.effect() == Statut.PV) {
            this.lifePoints = Math.min(consumable.value() + this.lifePoints, this.maxPV);
            System.out.println("Vous regagner "+consumable.value()+ " points de vie");
        }
        if (consumable.type() == Type.FOOD) {
            if (!this.listeFoodGame.isEmpty()) {
                System.out.println("Il vous reste " + this.listeFoodGame.size() + " morceau(x) de nourriture(s)");
            } else {
                System.out.println("Vous venez de consommer toute votre nourritures");
            }
        }
    }

    public Food removeFood() {
        return this.listeFoodGame.remove(listeFoodGame.size() - 1);
    }

    public Potion removePotion() {
        return this.listePotionsGame.remove(listePotionsGame.size() - 1);
    }

    public boolean isAliveHero() {
        if (this.lifePoints > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setListeFoodGame(List<Food> listeFoodGame) {
        this.listeFoodGame = listeFoodGame;
    }

    public void setListePotionsGame(List<Potion> listePotionsGame) {
        this.listePotionsGame = listePotionsGame;
    }

    public List<Food> getListeFoodGame() {
        return listeFoodGame;
    }

    public List<Potion> getListePotionsGame() {
        return listePotionsGame;
    }

    //public abstract void reward();


}

