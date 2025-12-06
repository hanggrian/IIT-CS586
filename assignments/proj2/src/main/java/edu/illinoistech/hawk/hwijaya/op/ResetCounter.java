package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the ResetCounter operation in the OutputProcessor.
 */
public interface ResetCounter {
    void initialize(DataStore dataStore);

    void resetCounter();
}
