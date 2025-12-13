package edu.illinoistech.hawk.hwijaya.state;

import edu.illinoistech.hawk.hwijaya.output.OutputProcessor;

/**
 * S8 state in the MDA-EFSM.
 */
public class S8 extends State {
    public S8(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void incorrectPin() {
        outputProcessor.wrongPinMsg();
        mdaEfsm.changeState(MdaEfsm.STATE_S0);
    }

    @Override
    public void correctPin() {
        outputProcessor.displayMenu();
        mdaEfsm.changeState(MdaEfsm.STATE_S3);
    }
}
