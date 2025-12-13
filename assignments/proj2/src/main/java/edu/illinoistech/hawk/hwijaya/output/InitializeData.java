package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the InitializeData operation in the OutputProcessor.
 */
public interface InitializeData {
    void initialize(DataStore dataStore);

    default void initializeData() {}
}
