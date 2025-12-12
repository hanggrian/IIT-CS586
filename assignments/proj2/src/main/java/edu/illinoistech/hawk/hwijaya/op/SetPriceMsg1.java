package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the SetPriceMsg operation for GasPump1.
 */
public class SetPriceMsg1 implements SetPriceMsg {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void setPrice(int gasType) {
        if (gasType != 1) {
            return;
        }
        out.println(
            on(
                "Regular gas: $"
                    + dataStore1.price
                    + "/liter"
            ).green()
        );
    }
}
