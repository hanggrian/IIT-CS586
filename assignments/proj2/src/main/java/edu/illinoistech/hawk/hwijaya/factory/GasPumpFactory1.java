package edu.illinoistech.hawk.hwijaya.factory;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;
import edu.illinoistech.hawk.hwijaya.output.CancelMsg;
import edu.illinoistech.hawk.hwijaya.output.CancelMsg1;
import edu.illinoistech.hawk.hwijaya.output.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.output.DisplayMenu1;
import edu.illinoistech.hawk.hwijaya.output.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.output.EnterPinMsg1;
import edu.illinoistech.hawk.hwijaya.output.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.output.GasPumpedMsg1;
import edu.illinoistech.hawk.hwijaya.output.InitializeData;
import edu.illinoistech.hawk.hwijaya.output.InitializeData1;
import edu.illinoistech.hawk.hwijaya.output.PayMsg;
import edu.illinoistech.hawk.hwijaya.output.PayMsg1;
import edu.illinoistech.hawk.hwijaya.output.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.output.PrintReceipt1;
import edu.illinoistech.hawk.hwijaya.output.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.output.PumpGasUnit1;
import edu.illinoistech.hawk.hwijaya.output.RejectMsg;
import edu.illinoistech.hawk.hwijaya.output.RejectMsg1;
import edu.illinoistech.hawk.hwijaya.output.ResetCounter;
import edu.illinoistech.hawk.hwijaya.output.ResetCounter1;
import edu.illinoistech.hawk.hwijaya.output.ReturnCash;
import edu.illinoistech.hawk.hwijaya.output.ReturnCash1;
import edu.illinoistech.hawk.hwijaya.output.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.output.SetPriceMsg1;
import edu.illinoistech.hawk.hwijaya.output.StopMsg;
import edu.illinoistech.hawk.hwijaya.output.StopMsg1;
import edu.illinoistech.hawk.hwijaya.output.StoreCash;
import edu.illinoistech.hawk.hwijaya.output.StoreCash1;
import edu.illinoistech.hawk.hwijaya.output.StorePin;
import edu.illinoistech.hawk.hwijaya.output.StorePin1;
import edu.illinoistech.hawk.hwijaya.output.StorePrices;
import edu.illinoistech.hawk.hwijaya.output.StorePrices1;
import edu.illinoistech.hawk.hwijaya.output.WrongPinMsg;
import edu.illinoistech.hawk.hwijaya.output.WrongPinMsg1;

/**
 * Concrete Factory class for Gas Pump 1.
 */
public class GasPumpFactory1 implements AbstractFactory {
    DataStore dataStore = new DataStore1();
    StorePrices storePrices = new StorePrices1();
    StoreCash storeCash = new StoreCash1();
    StorePin storePin = new StorePin1();
    InitializeData initializeData = new InitializeData1();
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
    public InitializeData getInitializeData() {
        return initializeData;
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
