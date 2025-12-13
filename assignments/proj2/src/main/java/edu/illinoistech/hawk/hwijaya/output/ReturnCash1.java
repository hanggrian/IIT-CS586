package edu.illinoistech.hawk.hwijaya.output;

import com.github.tomaslanger.chalk.Chalk;
import edu.illinoistech.hawk.hwijaya.RegexChalk;
import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

import static edu.illinoistech.hawk.hwijaya.RegexChalk.CURRENCY_REGEX;
import static java.lang.String.format;
import static java.lang.System.out;

/**
 * Implementation of the ReturnCash operation for GasPump1.
 */
public class ReturnCash1 implements ReturnCash {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void returnCash() {
        if (dataStore1.cash <= 0) {
            return;
        }
        out.println(
            new RegexChalk(
                dataStore1.cash == dataStore1.total
                    ? format("Paid $%.1f.", dataStore1.cash)
                    : format(
                    "Cash available $%.1f, returning $%.1f.",
                    dataStore1.cash,
                    dataStore1.cash - dataStore1.total
                )
            ).all(Chalk::green)
                .regex(CURRENCY_REGEX, Chalk::bold)
        );
    }
}
