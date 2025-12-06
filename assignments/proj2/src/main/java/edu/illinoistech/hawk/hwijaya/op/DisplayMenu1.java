package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

/**
 * Implementation of the DisplayMenu operation for GasPump1.
 */
public class DisplayMenu1 implements DisplayMenu {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void displayMenu() {
        System.out.println("Payment is approved, only regular is available.");
    }
}
