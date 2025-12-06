package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;

/**
 * Interface for the WrongPinMsg operation in the OutputProcessor.
 */
public interface WrongPinMsg {
    void initialize(DataStore dataStore);

    void wrongPinMsg();
}
