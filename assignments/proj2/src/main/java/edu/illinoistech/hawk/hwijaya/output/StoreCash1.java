package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

/**
 * Implementation of the StoreCash operation for GasPump1.
 */
public class StoreCash1 implements StoreCash {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void storeCash() {
        dataStore1.cash = dataStore1.tempCash;
    }
}
