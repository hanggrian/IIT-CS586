package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the DisplayMenu operation in the OutputProcessor.
 */
public interface DisplayMenu {
    void initialize(DataStore dataStore);

    void displayMenu();
}
