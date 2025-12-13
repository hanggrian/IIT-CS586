package edu.illinoistech.hawk.hwijaya;

import edu.illinoistech.hawk.hwijaya.factory.AbstractFactory;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;
import edu.illinoistech.hawk.hwijaya.state.MdaEfsm;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * GasPump1 class representing the operations of Gas Pump 1.
 */
public class GasPump1 {
    DataStore1 dataStore1;
    MdaEfsm mdaEfsm;

    public GasPump1(MdaEfsm mdaEfsm, AbstractFactory abstractFactory) {
        this.mdaEfsm = mdaEfsm;
        dataStore1 = (DataStore1) abstractFactory.getDataStore();
    }

    public void activate(float a) {
        if (a <= 0.0) {
            out.println(on("Positive price required.").red());
            return;
        }
        dataStore1.tempRegularPrice = a;
        mdaEfsm.activate();
    }

    public void start() {
        mdaEfsm.start();
    }

    public void payCash(float c) {
        dataStore1.tempCash = c;
        mdaEfsm.payCash();
    }

    public void payCredit() {
        mdaEfsm.payCredit();
    }

    public void approved() {
        mdaEfsm.approved();
    }

    public void reject() {
        mdaEfsm.rejected();
    }

    public void cancel() {
        mdaEfsm.cancel();
    }

    public void regular() {
        mdaEfsm.selectGas(1);
    }

    public void startPump() {
        mdaEfsm.startPump();
    }

    public void pumpLiter() {
        if (dataStore1.cash <= 0) {
            mdaEfsm.pump();
            return;
        }
        if (dataStore1.cash < dataStore1.regularPrice * (dataStore1.literCount + 1)) {
            mdaEfsm.stopPump();
        } else {
            mdaEfsm.pump();
        }
    }

    public void stopPump() {
        mdaEfsm.stopPump();
    }
}
