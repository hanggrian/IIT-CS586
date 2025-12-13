package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the GasPumpedMsg operation in the OutputProcessor.
 */
public interface GasPumpedMsg {
    void initialize(DataStore dataStore);

    default void gasPumpedMsg() {}
}
