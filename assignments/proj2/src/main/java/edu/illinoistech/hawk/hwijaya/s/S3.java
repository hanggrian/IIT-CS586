package edu.illinoistech.hawk.hwijaya.s;

import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;

/**
 * S3 state in the MDA-EFSM.
 */
public class S3 extends State {
    public S3(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void cancel() {
        outputProcessor.cancelMsg();
        outputProcessor.returnCash();
        mdaEfsm.changeState(MdaEfsm.STATE_S0);
    }

    @Override
    public void selectGas(int g) {
        outputProcessor.setPrice(g);
    }

    @Override
    public void startPump() {
        outputProcessor.resetCounter();
        mdaEfsm.changeState(MdaEfsm.STATE_S5);
    }
}
