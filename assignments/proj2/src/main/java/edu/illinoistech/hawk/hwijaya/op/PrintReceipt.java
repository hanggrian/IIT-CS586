package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the PrintReceipt operation in the OutputProcessor.
 */
public interface PrintReceipt {
    void initialize(DataStore dataStore);

    void printReceipt();
}
