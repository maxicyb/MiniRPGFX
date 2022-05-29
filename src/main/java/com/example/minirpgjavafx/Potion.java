package com.example.minirpgjavafx;

public class Potion implements Consumable{
    private final int valeur;
    private final String nom;

    Potion() {
        this("potion de mana (faible)");
    }

    Potion(String nom) {
        this(nom, 10);
    }

    Potion(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    @Override
    public Statut effect() {
        return Statut.MANA;
    }

    @Override
    public int value() {
        return valeur;
    }

    @Override
    public String nom() {
        return nom;
    }

    @Override
    public Type type() {
        return Type.POTION;
    }
}
