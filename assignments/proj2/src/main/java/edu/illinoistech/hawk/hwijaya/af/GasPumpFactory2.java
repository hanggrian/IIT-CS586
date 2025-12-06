package edu.illinoistech.hawk.hwijaya.af;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;
import edu.illinoistech.hawk.hwijaya.op.CancelMsg;
import edu.illinoistech.hawk.hwijaya.op.CancelMsg2;
import edu.illinoistech.hawk.hwijaya.op.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.op.DisplayMenu2;
import edu.illinoistech.hawk.hwijaya.op.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.op.EnterPinMsg2;
import edu.illinoistech.hawk.hwijaya.op.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.op.GasPumpedMsg2;
import edu.illinoistech.hawk.hwijaya.op.PayMsg;
import edu.illinoistech.hawk.hwijaya.op.PayMsg2;
import edu.illinoistech.hawk.hwijaya.op.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.op.PrintReceipt2;
import edu.illinoistech.hawk.hwijaya.op.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.op.PumpGasUnit2;
import edu.illinoistech.hawk.hwijaya.op.RejectMsg;
import edu.illinoistech.hawk.hwijaya.op.RejectMsg2;
import edu.illinoistech.hawk.hwijaya.op.ResetCounter;
import edu.illinoistech.hawk.hwijaya.op.ResetCounter2;
import edu.illinoistech.hawk.hwijaya.op.ReturnCash;
import edu.illinoistech.hawk.hwijaya.op.ReturnCash2;
import edu.illinoistech.hawk.hwijaya.op.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.op.SetPriceMsg2;
import edu.illinoistech.hawk.hwijaya.op.StopMsg;
import edu.illinoistech.hawk.hwijaya.op.StopMsg2;
import edu.illinoistech.hawk.hwijaya.op.StoreCash;
import edu.illinoistech.hawk.hwijaya.op.StoreCash2;
import edu.illinoistech.hawk.hwijaya.op.StorePin;
import edu.illinoistech.hawk.hwijaya.op.StorePin2;
import edu.illinoistech.hawk.hwijaya.op.StorePrices;
import edu.illinoistech.hawk.hwijaya.op.StorePrices2;
import edu.illinoistech.hawk.hwijaya.op.WrongPinMsg;
import edu.illinoistech.hawk.hwijaya.op.WrongPinMsg2;

/**
 * Concrete Factory class for Gas Pump 2.
 */
public class GasPumpFactory2 implements AbstractFactory {
    DataStore dataStore = new DataStore2();
    StorePrices storePrices = new StorePrices2();
    StoreCash storeCash = new StoreCash2();
    StorePin storePin = new StorePin2();
    PayMsg payMsg = new PayMsg2();
    DisplayMenu displayMenu = new DisplayMenu2();
    RejectMsg rejectMsg = new RejectMsg2();
    SetPriceMsg setPriceMsg = new SetPriceMsg2();
    ResetCounter resetCounter = new ResetCounter2();
    PumpGasUnit pumpGasUnit = new PumpGasUnit2();
    GasPumpedMsg gasPumpedMsg = new GasPumpedMsg2();
    StopMsg stopMsg = new StopMsg2();
    PrintReceipt printReceipt = new PrintReceipt2();
    CancelMsg cancelMsg = new CancelMsg2();
    ReturnCash returnCash = new ReturnCash2();
    WrongPinMsg wrongPinMsg = new WrongPinMsg2();
    EnterPinMsg enterPinMsg = new EnterPinMsg2();

    @Override
    public DataStore getDataStore() {
        return dataStore;
    }

    @Override
    public StorePrices getStorePrices() {
        return storePrices;
    }

    @Override
    public StorePin getStorePin() {
        return storePin;
    }

    @Override
    public StoreCash getStoreCash() {
        return storeCash;
    }

    @Override
    public PayMsg getPayMsg() {
        return payMsg;
    }

    @Override
    public DisplayMenu getDisplayMenu() {
        return displayMenu;
    }

    @Override
    public RejectMsg getRejectMsg() {
        return rejectMsg;
    }

    @Override
    public SetPriceMsg getSetPrice() {
        return setPriceMsg;
    }

    @Override
    public ResetCounter getResetCounter() {
        return resetCounter;
    }

    @Override
    public PumpGasUnit getPumpGasUnit() {
        return pumpGasUnit;
    }

    @Override
    public GasPumpedMsg getGasPumpedMsg() {
        return gasPumpedMsg;
    }

    @Override
    public StopMsg getStopMsg() {
        return stopMsg;
    }

    @Override
    public PrintReceipt getPrintReceipt() {
        return printReceipt;
    }

    public CancelMsg getCancelMsg() {
        return cancelMsg;
    }

    @Override
    public ReturnCash getReturnCash() {
        return returnCash;
    }

    @Override
    public WrongPinMsg getWrongPinMsg() {
        return wrongPinMsg;
    }

    @Override
    public EnterPinMsg getEnterPinMsg() {
        return enterPinMsg;
    }
}
