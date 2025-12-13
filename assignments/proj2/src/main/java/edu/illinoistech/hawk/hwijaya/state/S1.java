package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * S1 state in the MDA-EFSM.
 */
public class S1 extends State {
    public S1(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void payCredit() {
        // not displaying anything
        mdaEfsm.changeState(MdaEfsm.STATE_S2);
    }

    @Override
    public void payCash() {
        outputProcessor.storeCash();
        outputProcessor.displayMenu();
        mdaEfsm.changeState(MdaEfsm.STATE_S3);
    }

    @Override
    public void payDebit() {
        outputProcessor.enterPinMsg();
        outputProcessor.storePin();
        mdaEfsm.changeState(MdaEfsm.STATE_S8);
    }
}
