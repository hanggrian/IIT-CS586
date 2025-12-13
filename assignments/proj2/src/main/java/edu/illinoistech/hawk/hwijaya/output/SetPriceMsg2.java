package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.String.format;
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
    public void setPrice(int g) {
        if (g == 1) {
            out.println(on(format("Regular gas $%d @gallon", dataStore2.regularPrice)).green());
            dataStore2.price = dataStore2.regularPrice;
        } else if (g == 2) {
            out.println(on(format("Diesel gas $%d @gallon", dataStore2.regularPrice)).green());
            dataStore2.price = dataStore2.dieselPrice;
        }
    }
}
