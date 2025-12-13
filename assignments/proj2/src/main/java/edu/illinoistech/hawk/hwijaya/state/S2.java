package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * S2 state in the MDA-EFSM.
 */
public class S2 extends State {
    public S2(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void rejected() {
        outputProcessor.rejectMsg();
        mdaEfsm.changeState(MdaEfsm.STATE_S0);
    }

    @Override
    public void approved() {
        outputProcessor.displayMenu();
        mdaEfsm.changeState(MdaEfsm.STATE_S3);
    }
}
