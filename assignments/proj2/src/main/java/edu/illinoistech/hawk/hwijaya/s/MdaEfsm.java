package edu.illinoistech.hawk.hwijaya.s;

import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;

/**
 * MdaEfsm class representing the finite state machine for the gas pump system.
 */
public class MdaEfsm {
    public static final int STATE_START = 0;
    public static final int STATE_S0 = 1;
    public static final int STATE_S1 = 2;
    public static final int STATE_S2 = 3;
    public static final int STATE_S3 = 4;
    public static final int STATE_S5 = 5;
    public static final int STATE_S8 = 6;

    State[] states = new State[7];
    State currentState;

    public MdaEfsm(OutputProcessor outputProcessor) {
        states[STATE_START] = new Start(this, outputProcessor);
        states[STATE_S0] = new S0(this, outputProcessor);
        states[STATE_S1] = new S1(this, outputProcessor);
        states[STATE_S2] = new S2(this, outputProcessor);
        states[STATE_S3] = new S3(this, outputProcessor);
        states[STATE_S5] = new S5(this, outputProcessor);
        states[STATE_S8] = new S8(this, outputProcessor);

        currentState = states[STATE_START];
    }

    public void changeState(int i) {
        currentState = states[i];
    }

    public void activate() {
        currentState.activate();
    }

    public void start() {
        currentState.start();
    }

    public void payCash() {
        currentState.payCash();
    }

    public void payCredit() {
        currentState.payCredit();
    }

    public void approved() {
        currentState.approved();
    }

    public void rejected() {
        currentState.rejected();
    }

    public void cancel() {
        currentState.cancel();
    }

    public void payDebit() {
        currentState.payDebit();
    }

    public void incorrectPin(int max) {
        currentState.incorrectPin(max);
    }

    public void correctPin() {
        currentState.correctPin();
    }

    public void selectGas(int g) {
        currentState.selectGas(g);
    }

    public void startPump() {
        currentState.startPump();
    }

    public void pump() {
        currentState.pump();
    }

    public void stopPump() {
        currentState.stopPump();
    }
}
