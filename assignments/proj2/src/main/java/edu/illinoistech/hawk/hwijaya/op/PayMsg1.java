package edu.illinoistech.hawk.hwijaya.op;

/**
 * Implementation of the PayMsg operation for GasPump1.
 */
public class PayMsg1 implements PayMsg {
    @Override
    public void payMsg() {
        System.out.println("Cash and credit card are supported.");
    }
}
