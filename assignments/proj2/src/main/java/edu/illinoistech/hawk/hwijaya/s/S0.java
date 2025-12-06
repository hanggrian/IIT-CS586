package edu.illinoistech.hawk.hwijaya.s;

import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;

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
        mdaEfsm.changeState(MdaEfsm.STATE_S1);
    }
}
