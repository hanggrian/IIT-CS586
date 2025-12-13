package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the StorePrices operation for GasPump2.
 */
public class StorePrices2 implements StorePrices {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void storePrices() {
        dataStore2.regularPrice = dataStore2.tempRegularPrice;
        dataStore2.dieselPrice = dataStore2.tempDieselPrice;
        out.println(on("Prices stored.").green());
    }
}
