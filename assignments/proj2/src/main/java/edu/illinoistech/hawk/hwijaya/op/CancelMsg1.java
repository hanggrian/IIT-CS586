package edu.illinoistech.hawk.hwijaya.op;

/**
 * Implementation of the CancelMsg operation for GasPump1.
 */
public class CancelMsg1 implements CancelMsg {
    @Override
    public void cancelMsg(){
        System.out.println("Credit or cash transaction cancelled, start again.");
    }
}
