package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the PumpGasUnit operation in the OutputProcessor.
 */
public interface PumpGasUnit {
    void initialize(DataStore dataStore);

    void pumpGasUnit();
}
