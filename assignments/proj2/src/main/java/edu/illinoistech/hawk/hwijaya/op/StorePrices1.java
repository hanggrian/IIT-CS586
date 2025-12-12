package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the StorePrices operation for GasPump1.
 */
public class StorePrices1 implements StorePrices {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void storePrices() {
        dataStore1.price = dataStore1.tempA;
        out.println(on("Prices stored.").green());
    }
}
