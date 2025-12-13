package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Interface for the SetPriceMsg operation in the OutputProcessor.
 */
public interface SetPriceMsg {
    void initialize(DataStore dataStore);

    default void setPrice(int g) {}
}
