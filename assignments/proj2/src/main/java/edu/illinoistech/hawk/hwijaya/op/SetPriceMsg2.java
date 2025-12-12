package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

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
            out.println(
                on(
                    "Regular gas: $"
                        + dataStore2.price
                        + "/gallon"
                ).green()
            );
        } else if (gasType == 2) {
            dataStore2.price = dataStore2.dieselPrice;
            out.println(
                on(
                    "Diesel gas: $"
                        + dataStore2.price
                        + "/gallon"
                ).green()
            );
        }
    }
}
