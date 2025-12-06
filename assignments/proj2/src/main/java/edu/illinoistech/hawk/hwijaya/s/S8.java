package edu.illinoistech.hawk.hwijaya.s;

import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;

/**
 * S8 state in the MDA-EFSM.
 */
public class S8 extends State {
    int k = 0;

    public S8(MdaEfsm mdaEfsm, OutputProcessor outputProcessor) {
        super(mdaEfsm, outputProcessor);
    }

    @Override
    public void incorrectPin(int max) {
        outputProcessor.wrongPinMsg();
        if (k > max) {
            mdaEfsm.changeState(MdaEfsm.STATE_S0);
        } else if (k <= max) {
            k++;
        }
    }

    @Override
    public void correctPin() {
        outputProcessor.displayMenu();
        mdaEfsm.changeState(MdaEfsm.STATE_S3);
        k = 0;
    }
}
