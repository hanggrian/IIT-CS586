package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

/**
 * Implementation of the ResetCounter operation for GasPump2.
 */
public class ResetCounter2 implements ResetCounter {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void resetCounter() {
        dataStore2.total = 0;
        dataStore2.gallonCount = 0;
        System.out.println("Total and gallon count reset.");
    }
}
