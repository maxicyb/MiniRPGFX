package com.example.minirpgjavafx;

import java.util.Random;

public abstract class Enemy {

    protected int lifePointsE;
    protected int maxLifePointsE;
    protected double weaponDamageE;


    public int getLifePointsE() {
        return lifePointsE;
    }

    public int getMaxLifePointsE() {
        return maxLifePointsE;
    }

    public void setLifePointsE(int lifePointsE) { this.lifePointsE = lifePointsE; }

    public double getWeaponDamageE() {
        return weaponDamageE;
    }

    public static Enemy generateEnemy() {

        Random willYouHaveLuck = new Random();

        int probability = willYouHaveLuck.nextInt(101);
        if (probability > 80) {
            //generateBossEnemy();
            return new BossEnemy();

        } else {
            //generateBasicEnemy();
            return new BasicEnemy();

        }

    }

    public boolean isAliveEnemy(){
        if (this.lifePointsE>0){
            return true;
        }
        else {
            return false;
        }

    }




}
