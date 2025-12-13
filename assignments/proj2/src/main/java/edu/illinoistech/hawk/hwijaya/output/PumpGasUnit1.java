package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PumpGasUnit operation for GasPump1.
 */
public class PumpGasUnit1 implements PumpGasUnit {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void pumpGasUnit() {
        out.println(on("Pumping one liter...").green());
        int liter = dataStore1.literCount + 1;
        dataStore1.total = liter * dataStore1.price;
        dataStore1.literCount = liter;
    }
}
