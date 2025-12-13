package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

/**
 * Implementation of the InitializeData operation for GasPump2.
 */
public class InitializeData2 implements InitializeData {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void initializeData() {
        dataStore2.price = 0;
    }
}
