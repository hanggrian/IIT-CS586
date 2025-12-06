package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the StorePrices operation in the OutputProcessor.
 */
public interface StorePrices {
    void initialize(DataStore dataStore);

    void storePrices();
}
