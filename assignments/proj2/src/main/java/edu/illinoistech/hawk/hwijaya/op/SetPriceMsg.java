package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the SetPriceMsg operation in the OutputProcessor.
 */
public interface SetPriceMsg {
    void initialize(DataStore dataStore);

    void setPrice(int gasType);
}
