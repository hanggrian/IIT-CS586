package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the StorePrices operation in the OutputProcessor.
 */
public interface StorePrices {
    void initialize(DataStore dataStore);

    default void storePrices() {}
}
