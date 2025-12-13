package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * Using state pattern, State class is a generic state in the MDA-EFSM.
 */
public class State {
    MdaEfsm mdaEfsm;
    OutputProcessor outputProcessor;

    public State(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        this.mdaEfsm = mdaEfsm;
        this.outputProcessor = outputProcessor;
    }

    public void activate() {}

    public void start() {}

    public void payCash() {}

    public void payCredit() {}

    public void approved() {}

    public void rejected() {}

    public void cancel() {}

    public void payDebit() {}

    public void incorrectPin() {}

    public void correctPin() {}

    public void selectGas(int gasType) {}

    public void startPump() {}

    public void pump() {}

    public void stopPump() {}
}
