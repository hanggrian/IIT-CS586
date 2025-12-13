package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

/**
 * Implementation of the InitializeData operation for GasPump1.
 */
public class InitializeData1 implements InitializeData {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void initializeData() {
        dataStore1.price = 0;
        dataStore1.cash = 0;
    }
}
