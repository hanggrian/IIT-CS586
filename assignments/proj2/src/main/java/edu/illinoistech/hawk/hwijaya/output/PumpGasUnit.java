package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the PumpGasUnit operation in the OutputProcessor.
 */
public interface PumpGasUnit {
    void initialize(DataStore dataStore);

    default void pumpGasUnit() {}
}
