package com.demo.service;

import com.demo.model.Machine;

public interface IMachineService {

    void insertCoins(Machine machine, int coins);

    void resetMachine(Machine machine);
}
