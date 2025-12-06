package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

/**
 * Implementation of the GasPumpedMsg operation for GasPump1.
 */
public class GasPumpedMsg1 implements GasPumpedMsg {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    public void gasPumpedMsg() {
        System.out.println(
            "1 gallon has been pumped.\n"
                + "Total liter = " + dataStore1.literCount
        );
    }
}
