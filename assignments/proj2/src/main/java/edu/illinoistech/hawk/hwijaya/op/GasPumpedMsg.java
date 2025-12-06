package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the GasPumpedMsg operation in the OutputProcessor.
 */
public interface GasPumpedMsg {
    void initialize(DataStore dataStore);

    void gasPumpedMsg();
}
