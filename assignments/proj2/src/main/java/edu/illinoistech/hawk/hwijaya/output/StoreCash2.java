package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

/**
 * Implementation of the StoreCash operation for GasPump2.
 */
public class StoreCash2 implements StoreCash {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }
}
