package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the ResetCounter operation in the OutputProcessor.
 */
public interface ResetCounter {
    void initialize(DataStore dataStore);

    default void resetCounter() {}
}
