package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * S5 state in the MDA-EFSM.
 */
public class S5 extends State {
    public S5(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void pump() {
        outputProcessor.pumpGasUnit();
        outputProcessor.gasPumpedMsg();
    }

    @Override
    public void stopPump() {
        outputProcessor.printReceipt();
        outputProcessor.returnCash();
        mdaEfsm.changeState(MdaEfsm.STATE_S0);
    }
}
