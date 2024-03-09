package com.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Machine {

    private int insertedCoins;

    private static Machine instance;

    public Machine(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public static Machine getInstance() {
        if (instance == null) {
            instance = new Machine(0);
        }
        return instance;
    }

    public void insertCoins(int coins) {
        this.insertedCoins += coins;
    }

    public void resetMachine() {
        this.insertedCoins = 0;
    }
}
