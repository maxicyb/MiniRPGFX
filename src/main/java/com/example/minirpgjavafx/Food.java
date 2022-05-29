package com.example.minirpgjavafx;

public class Food implements Consumable{
    private final int valeur;
    private final String nom;

    Food() {
        this("Gros burger");
    }

    Food(String nom) {
        this(nom, 10);
    }

    Food(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    @Override
    public Statut effect() {
        return Statut.PV;
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
        return Type.FOOD;
    }

}


