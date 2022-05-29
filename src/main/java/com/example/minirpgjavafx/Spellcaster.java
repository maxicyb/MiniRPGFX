package com.example.minirpgjavafx;

import java.util.List;

abstract class Spellcaster extends Hero {

    protected int manaPoints;
    protected int maxManaPoints;
    protected int manaUsed;

    public Spellcaster(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed) {
        this(pv, pvMax, armure, degats, manaPoints, maxManaPoints, manaUsed, null);
    }

    public Spellcaster(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed, List<Food> foods) {
        this(pv, pvMax, armure, degats, manaPoints, maxManaPoints, manaUsed, foods, null);
    }

    public Spellcaster(int pv, int pvMax, int armure, int degats, int manaPoints, int maxManaPoints, int manaUsed, List<Food> foods, List<Potion> potions) {
        super(pv, pvMax, armure, degats, foods, potions);
        this.manaPoints = manaPoints;
        this.maxManaPoints = maxManaPoints;
        this.manaUsed = manaUsed;
    }


    @Override
    public void useConsumable(Consumable consumable) {
        super.useConsumable(consumable);
        if (consumable.effect() == Statut.MANA) {
            //this.manaPoints = (condition) ? valeurIfTrue : valeurIfFalse;
            this.manaPoints = Math.min(consumable.value() + this.manaPoints, this.maxManaPoints);
            System.out.println("Cela vous rends " + consumable.value() + " points de mana.");
        }
        if (consumable.type() == Type.POTION) {
            if (!this.listePotionsGame.isEmpty()) {
                System.out.println("Il vous reste " + this.listePotionsGame.size() + " potion(s)");
            } else {
                System.out.println("Vous venez de consommer toute vos potions");
            }
        }
    }
}
