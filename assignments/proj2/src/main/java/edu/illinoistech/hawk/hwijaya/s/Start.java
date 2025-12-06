package edu.illinoistech.hawk.hwijaya.s;

import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;

/**
 * Start state in the MDA-EFSM.
 */
public class Start extends State {
    public Start(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void activate() {
        outputProcessor.storePrices();
        mdaEfsm.changeState(MdaEfsm.STATE_S0);
    }
}
