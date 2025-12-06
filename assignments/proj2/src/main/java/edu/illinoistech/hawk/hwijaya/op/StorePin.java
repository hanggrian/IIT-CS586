package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the StorePin operation in the OutputProcessor.
 */
public interface StorePin {
    void initialize(DataStore dataStore);

    void storePin();
}
