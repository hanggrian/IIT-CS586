package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PumpGasUnit operation for GasPump2.
 */
public class PumpGasUnit2 implements PumpGasUnit {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void pumpGasUnit() {
        out.println(on("Pumping one gallon...").green());
        int gallon = dataStore2.gallonCount + 1;
        dataStore2.total = gallon * dataStore2.price;
        dataStore2.gallonCount = gallon;
    }
}
