package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

/**
 * Implementation of the ReturnCash operation for GasPump1.
 */
public class ReturnCash1 implements ReturnCash {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void returnCash() {
        float total = dataStore1.total;
        float cash = dataStore1.cash;
        if (cash - total > 0) {
            System.out.println("Collected $" + (cash - total) + ".");
        } else {
            System.out.println("Nothing to return.");
        }
        dataStore1.literCount = 0;
        dataStore1.cash = 0;
        dataStore1.total = 0;
    }
}
