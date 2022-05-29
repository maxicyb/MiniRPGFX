package com.example.minirpgjavafx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    final List<String> displayListeHeros = Arrays.asList("Hunter", "Mage", "Warrior");
    final List<String> listeActions = Arrays.asList("Attaquer", "Défendre", "Utiliser un consommable");
    final List<String> listeConsumables = Arrays.asList("Nourriture", "Potion");

    public int nbreHeros;
    final List<String> herosChoisis = new ArrayList<>();
    public List<Hero> listeHerosGame = new ArrayList<>();
    public List<Enemy> listeEnemyGame = new ArrayList<>();
    public Hero heroChoisi;



    public void adventure(Scanner scanner) {
        //On choisit le nombre de héros
        System.out.println("Bienvenue jeune aventurier, combien de héros souhaite tu choisir ?");
        System.out.print(">");
        nbreHeros = scanner.nextInt();
        displayHeros();
        choseHeros(scanner);
        heroChoisi = listeHerosGame.remove(listeHerosGame.size() - 1);
        while(!listeHerosGame.isEmpty() || heroChoisi.isAliveHero()) {
            generateCombat();
            combat(scanner);
        }

    }

    public void adventureGUI(List<Hero> listeHerosGame){

        heroChoisi = listeHerosGame.remove(listeHerosGame.size() - 1);
        while(!listeHerosGame.isEmpty() || heroChoisi.isAliveHero()) {
            generateCombat();

        }
    }

    //Does not concern GUI
    public void displayHeros() {
        System.out.println("Bien joué pour ce premier pas ! Les héros sont : ");
        for (int i = 0; displayListeHeros.size() > i; i++) {
            System.out.println((i + 1) + " : " + displayListeHeros.get(i));
        }
    }

    //Does not concern GUI
    public void displayActions() {
        for (int i = 0; listeActions.size() > i; i++) {
            System.out.println((i + 1) + " : " + listeActions.get(i));
        }
    }

    //Does not concern GUI
    public void displayConsumables() {
        for (int i = 0; listeConsumables.size() > i; i++) {
            System.out.println((i + 1) + " : " + listeConsumables.get(i));
        }
    }

    //Does not concern GUI
    public void choseHeros(Scanner scanner) {
        System.out.println("Quel(s) héros voulez vous choisir ?");
        System.out.print(">");

        for (int i = 0; this.nbreHeros > i; i++) {
            int choixPlayer = scanner.nextInt();
            choixPlayer = choixPlayer - 1;

            herosChoisis.add(displayListeHeros.get(choixPlayer));
            System.out.print(">");

        }


        System.out.println("Vos héros choisis sont :  " + Arrays.toString(herosChoisis.toArray()));
        List<Food> foods = List.of(new Food());
        List<Potion> potions = List.of(new Potion());
        for (String choice : herosChoisis) {
            switch (choice) {
                case "Hunter" -> {
                    Hero h = new Hunter(130, 130, 45, 20, 25, foods);
                    listeHerosGame.add(h);
                }
                case "Mage" -> {
                    Hero m = new Mage(100, 100, 20, 30, 50, 50, 10, foods, potions);
                    listeHerosGame.add(m);
                }
                case "Warrior" -> {
                    Hero w = new Warrior(200, 200, 75, 17, foods);
                    listeHerosGame.add(w);
                }
            }

        }

        System.out.println(listeHerosGame);

    }

    public void choseHerosGUI(String type) {

        List<Food> foods = List.of(new Food());
        List<Potion> potions = List.of(new Potion());
            switch (type) {
                case "Hunter" -> {
                    Hero h = new Hunter(130, 130, 45, 20, 25, foods);
                    listeHerosGame.add(h);
                }
                case "Mage" -> {
                    Hero m = new Mage(100, 100, 20, 30, 50, 50, 10, foods, potions);
                    listeHerosGame.add(m);
                }
                case "Warrior" -> {
                    Hero w = new Warrior(200, 200, 75, 17, foods);
                    listeHerosGame.add(w);
                }
            }



    }

    public void generateCombat() {
        System.out.println("Un ennemi sort de l'ombre pour vous défier au combat");
        listeEnemyGame.add(Enemy.generateEnemy());
    }

    public void combat(Scanner scanner) {

        System.out.println("Que souhaitez vous faire ? ");
        displayActions();
        System.out.print(">");
        double coefDef = 1;

        int Choice = scanner.nextInt();
        switch (Choice) {
            case 1 -> attack();
            case 2 -> coefDef = defend();
            case 3 -> {
                System.out.println("Que voulez vous utiliser ? : ");
                displayConsumables();
                switch (scanner.nextInt()) {
                    case 1 -> useConsumable(Type.FOOD);
                    case 2 -> useConsumable(Type.POTION);
                }
            }
        }
        attackEnemy(coefDef);
        if (!heroChoisi.isAliveHero()) {
            System.out.println("Votre héros est mort ...");
            if (listeHerosGame.isEmpty()) {
                System.out.println("Fin de la partie il ne reste plus de héros...");
                System.exit(0);
            } else {
                System.out.println("On passe sur l'autre heros");
                heroChoisi = getNextHero();
                System.out.println(heroChoisi+ " à l'attaque !");
            }
        }
        if (listeEnemyGame.isEmpty()) {
            System.out.println("Bravo vous avez gagné le combat");
            reward(scanner);
        } else {
            combat(scanner);
        }
    }




    public void attack() {
        Enemy enemy = listeEnemyGame.get(listeEnemyGame.size() - 1);
        if (heroChoisi.attack()) {
            enemy.setLifePointsE(enemy.getLifePointsE() - heroChoisi.getWeaponDamage());
            System.out.println("Votre attaque inflige " + heroChoisi.getWeaponDamage() + " dégats");
            if (enemy.isAliveEnemy()) {
                System.out.println("L'ennemi possède encore : " + enemy.getLifePointsE() + "/ " + enemy.getMaxLifePointsE() + " HP");
            } else {
                System.out.println("L'ennemi est mort suite à votre attaque.");
            }
        }
    }

    public void useConsumable(Type choice){
        switch (choice) {
            case POTION -> {
                System.out.println("Vous souhaitez utiliser une potion");
                if (!heroChoisi.getListePotionsGame().isEmpty()) {
                    heroChoisi.useConsumable(heroChoisi.removePotion());
                } else {
                    System.out.println("En fouillant votre sacoche vous vous rendez compte que vous n'avez plus une seule potion...");
                }
            }
            case FOOD -> {
                System.out.println("Vous souhaitez manger de la nourriture");
                if (!heroChoisi.getListeFoodGame().isEmpty()) {
                    heroChoisi.useConsumable(heroChoisi.removeFood());

                } else {
                    System.out.println("Votre sac de nourriture est vide ...");
                }
            }
        }


    }

    public void reward(Scanner scanner) {
        System.out.println("Vous pouvez choisir une récompense :");
        heroChoisi.reward(scanner);
    }

    public double defend(){
        Enemy enemy = listeEnemyGame.get(listeEnemyGame.size() - 1);
        System.out.println("L'ennemi possède encore : " + enemy.getLifePointsE() + "/ " + enemy.getMaxLifePointsE() + " HP ");
        return ((double)(100 - heroChoisi.getArmor()) / 100);
    }

    public void attackEnemy(double coefDef) {
        Enemy enemy = listeEnemyGame.get(listeEnemyGame.size() - 1);
        if (enemy.isAliveEnemy()) {
            double enemyAttack = (enemy.getWeaponDamageE() * coefDef);
            heroChoisi.setLifePoints(heroChoisi.getLifePoints() - enemyAttack);
            if(coefDef < 1) {
                System.out.println("L'ennemi vous attaque, vous vous défendez !!");
                System.out.println("OUCH suite à votre défense vous avez : " + heroChoisi.getLifePoints() + "/" + heroChoisi.getMaxPV() + " HP, l'ennemi vous a infligé : "+enemyAttack+" dégats");
            } else  {
                System.out.println("L'ennemi vous attaque !!");
                System.out.println("OUCH vous avez : " + heroChoisi.getLifePoints() + "/" + heroChoisi.getMaxPV() + " HP");
            }
        } else {
            listeEnemyGame.remove(listeEnemyGame.size() - 1);
        }
    }

    public Hero getNextHero() {
        return listeHerosGame.remove(listeHerosGame.size() - 1);

    }


}
