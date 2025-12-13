package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the StoreCash operation in the OutputProcessor.
 */
public interface StoreCash {
    void initialize(DataStore dataStore);

    default void storeCash() {}
}
