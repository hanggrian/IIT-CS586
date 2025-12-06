package edu.illinoistech.hawk.hwijaya.op;

/**
 * Interface for the StopMsg operation in the OutputProcessor.
 */
public interface StopMsg {
    default void stopMessage() {
        System.out.println("Gas pump stopped, please collect your receipt.");
    }
}
