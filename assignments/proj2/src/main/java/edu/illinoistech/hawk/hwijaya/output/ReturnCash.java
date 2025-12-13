package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the ReturnCash operation in the OutputProcessor.
 */
public interface ReturnCash {
    void initialize(DataStore dataStore);

    default void returnCash() {}
}
