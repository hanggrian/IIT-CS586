package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the StorePin operation in the OutputProcessor.
 */
public interface StorePin {
    void initialize(DataStore dataStore);

    default void storePin() {}
}
