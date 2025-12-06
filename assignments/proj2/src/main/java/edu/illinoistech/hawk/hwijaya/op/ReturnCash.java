package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the ReturnCash operation in the OutputProcessor.
 */
public interface ReturnCash {
    void initialize(DataStore dataStore);

    void returnCash();
}
