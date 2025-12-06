package edu.illinoistech.hawk.hwijaya.gp;

import edu.illinoistech.hawk.hwijaya.af.AbstractFactory;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;
import edu.illinoistech.hawk.hwijaya.s.MdaEfsm;

/**
 * GasPump2 class representing the operations of Gas Pump 2.
 */
public class GasPump2 {
    DataStore2 dataStore2;
    MdaEfsm mdaEfsm;

    public GasPump2(MdaEfsm mdaEfsm, AbstractFactory abstractFactory) {
        this.mdaEfsm = mdaEfsm;
        dataStore2 = (DataStore2) abstractFactory.getDataStore();
    }

    public void activate(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("PRICES NEED TO BE GREATER THAN 0");
            return;
        }
        dataStore2.tempA = a;
        dataStore2.tempB = b;
        mdaEfsm.activate();
    }

    public void start() {
        mdaEfsm.start();
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

    public void payDebit(int p) {
        dataStore2.tempP = p;
        mdaEfsm.payDebit();
    }

    public void pin(int p) {
        if (dataStore2.pin == p) {
            mdaEfsm.correctPin();
        } else {
            mdaEfsm.incorrectPin(1);
        }
    }

    public void diesel() {
        mdaEfsm.selectGas(1);
    }

    public void regular() {
        mdaEfsm.selectGas(2);
    }

    public void startPump() {
        if (dataStore2.price > 0) {
            mdaEfsm.startPump();
        }
    }

    public void pumpGallon() {
        mdaEfsm.pump();
    }

    public void stopPump() {
        mdaEfsm.stopPump();
    }

    public void fullTank() {
        mdaEfsm.stopPump();
    }
}
