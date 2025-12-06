package edu.illinoistech.hawk.hwijaya.op;

/**
 * Interface for the RejectMsg operation in the OutputProcessor.
 */
public interface RejectMsg {
    default void rejectMsg(){
        System.out.println("Credit card rejected.");
    }
}
