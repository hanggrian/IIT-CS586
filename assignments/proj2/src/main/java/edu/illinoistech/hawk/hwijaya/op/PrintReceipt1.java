package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

/**
 * Implementation of the PrintReceipt operation for GasPump1.
 */
public class PrintReceipt1 implements PrintReceipt {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void printReceipt() {
        System.out.println(
            "Receipt:\n"
                + "Liter = " + dataStore1.literCount + '\n'
                + "Total = $" + dataStore1.total
        );
    }
}
