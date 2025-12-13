package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.String.format;
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
    public void setPrice(int g) {
        if (g != 1) {
            return;
        }
        out.println(on(format("Regular gas $%.1f @liter", dataStore1.regularPrice)).green());
        dataStore1.price = dataStore1.regularPrice;
    }
}
