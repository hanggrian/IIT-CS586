package edu.illinoistech.hawk.hwijaya.af;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;
import edu.illinoistech.hawk.hwijaya.op.CancelMsg;
import edu.illinoistech.hawk.hwijaya.op.CancelMsg1;
import edu.illinoistech.hawk.hwijaya.op.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.op.DisplayMenu1;
import edu.illinoistech.hawk.hwijaya.op.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.op.EnterPinMsg1;
import edu.illinoistech.hawk.hwijaya.op.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.op.GasPumpedMsg1;
import edu.illinoistech.hawk.hwijaya.op.PayMsg;
import edu.illinoistech.hawk.hwijaya.op.PayMsg1;
import edu.illinoistech.hawk.hwijaya.op.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.op.PrintReceipt1;
import edu.illinoistech.hawk.hwijaya.op.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.op.PumpGasUnit1;
import edu.illinoistech.hawk.hwijaya.op.RejectMsg;
import edu.illinoistech.hawk.hwijaya.op.RejectMsg1;
import edu.illinoistech.hawk.hwijaya.op.ResetCounter;
import edu.illinoistech.hawk.hwijaya.op.ResetCounter1;
import edu.illinoistech.hawk.hwijaya.op.ReturnCash;
import edu.illinoistech.hawk.hwijaya.op.ReturnCash1;
import edu.illinoistech.hawk.hwijaya.op.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.op.SetPriceMsg1;
import edu.illinoistech.hawk.hwijaya.op.StopMsg;
import edu.illinoistech.hawk.hwijaya.op.StopMsg1;
import edu.illinoistech.hawk.hwijaya.op.StoreCash;
import edu.illinoistech.hawk.hwijaya.op.StoreCash1;
import edu.illinoistech.hawk.hwijaya.op.StorePin;
import edu.illinoistech.hawk.hwijaya.op.StorePin1;
import edu.illinoistech.hawk.hwijaya.op.StorePrices;
import edu.illinoistech.hawk.hwijaya.op.StorePrices1;
import edu.illinoistech.hawk.hwijaya.op.WrongPinMsg;
import edu.illinoistech.hawk.hwijaya.op.WrongPinMsg1;

/**
 * Concrete Factory class for Gas Pump 1.
 */
public class GasPumpFactory1 implements AbstractFactory {
    DataStore dataStore = new DataStore1();
    StorePrices storePrices = new StorePrices1();
    StoreCash storeCash = new StoreCash1();
    StorePin storePin = new StorePin1();
    PayMsg payMsg = new PayMsg1();
    DisplayMenu displayMenu = new DisplayMenu1();
    RejectMsg rejectMsg = new RejectMsg1();
    SetPriceMsg setPriceMsg = new SetPriceMsg1();
    ResetCounter resetCounter = new ResetCounter1();
    PumpGasUnit pumpGasUnit = new PumpGasUnit1();
    GasPumpedMsg gasPumpedMsg = new GasPumpedMsg1();
    StopMsg stopMsg = new StopMsg1();
    PrintReceipt printReceipt = new PrintReceipt1();
    CancelMsg cancelMsg = new CancelMsg1();
    ReturnCash returnCash = new ReturnCash1();
    WrongPinMsg wrongPinMsg = new WrongPinMsg1();
    EnterPinMsg enterPinMsg = new EnterPinMsg1();

    @Override
    public DataStore getDataStore() {
        return dataStore;
    }

    @Override
    public StorePrices getStorePrices() {
        return storePrices;
    }

    @Override
    public StoreCash getStoreCash() {
        return storeCash;
    }

    @Override
    public StorePin getStorePin() {
        return storePin;
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

    @Override
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
