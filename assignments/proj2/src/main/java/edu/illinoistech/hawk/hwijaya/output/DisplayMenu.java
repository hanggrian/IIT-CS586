package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the DisplayMenu operation in the OutputProcessor.
 */
public interface DisplayMenu {
    void initialize(DataStore dataStore);

    default void displayMenu() {}
}
