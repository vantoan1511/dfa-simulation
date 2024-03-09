package com.demo.service;

import com.demo.model.Machine;
import org.springframework.stereotype.Service;

@Service
public class MachineService implements IMachineService {

    @Override
    public void insertCoins(Machine machine, int coins) {
        machine.insertCoins(coins);
    }

    @Override
    public void resetMachine(Machine machine) {
        machine.resetMachine();
    }
}
