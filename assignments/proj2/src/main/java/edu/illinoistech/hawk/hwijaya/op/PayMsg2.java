package edu.illinoistech.hawk.hwijaya.op;

/**
 * Implementation of the PayMsg operation for GasPump2.
 */
public class PayMsg2 implements PayMsg {
    @Override
    public void payMsg() {
        System.out.println("Debit card and credit card are supported.");
    }
}
