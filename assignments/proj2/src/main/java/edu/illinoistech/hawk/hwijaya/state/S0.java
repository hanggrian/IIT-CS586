package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * S0 state in the MDA-EFSM.
 */
public class S0 extends State {
    public S0(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void start() {
        outputProcessor.payMsg();
        outputProcessor.initializeData();
        mdaEfsm.changeState(MdaEfsm.STATE_S1);
    }
}
