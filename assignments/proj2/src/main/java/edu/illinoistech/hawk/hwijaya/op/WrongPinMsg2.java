package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

/**
 * Implementation of the WrongPinMsg operation for GasPump2.
 */
public class WrongPinMsg2 implements WrongPinMsg {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void wrongPinMsg() {
        System.out.println("Wrong pin, try again...");
    }
}
