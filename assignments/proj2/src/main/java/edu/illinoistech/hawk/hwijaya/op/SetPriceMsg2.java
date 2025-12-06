package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

/**
 * Implementation of the SetPriceMsg operation for GasPump2.
 */
public class SetPriceMsg2 implements SetPriceMsg {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void setPrice(int gasType) {
        if (gasType == 1) {
            dataStore2.price = dataStore2.regularPrice;
            System.out.println(
                "Regular gas: $"
                    + dataStore2.price
                    + "/gallon"
            );
        } else if (gasType == 2) {
            dataStore2.price = dataStore2.dieselPrice;
            System.out.println(
                "Diesel gas: $"
                    + dataStore2.price
                    + "/gallon"
            );
        }
    }
}
