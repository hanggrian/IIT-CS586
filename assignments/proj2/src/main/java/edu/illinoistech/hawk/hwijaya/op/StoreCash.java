package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the StoreCash operation in the OutputProcessor.
 */
public interface StoreCash {
    void initialize(DataStore dataStore);

    void storeCash();
}
