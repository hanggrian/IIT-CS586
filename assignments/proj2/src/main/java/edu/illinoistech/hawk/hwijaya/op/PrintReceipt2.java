package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

/**
 * Implementation of the PrintReceipt operation for GasPump2.
 */
public class PrintReceipt2 implements PrintReceipt {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void printReceipt() {
        System.out.println(
            "Receipt:\n"
                + "Gallon = " + dataStore2.gallonCount + '\n'
                + "Total = $" + dataStore2.total
        );
    }
}
