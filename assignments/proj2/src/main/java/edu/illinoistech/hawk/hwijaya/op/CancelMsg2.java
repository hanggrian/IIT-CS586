package edu.illinoistech.hawk.hwijaya.op;

/**
 * Implementation of the CancelMsg operation for GasPump2.
 */
public class CancelMsg2 implements CancelMsg {
    @Override
    public void cancelMsg(){
        System.out.println("Credit or debit transaction cancelled, start again.");
    }
}
