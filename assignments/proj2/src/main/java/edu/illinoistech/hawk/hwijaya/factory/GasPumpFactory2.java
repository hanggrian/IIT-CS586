package edu.illinoistech.hawk.hwijaya.factory;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;
import edu.illinoistech.hawk.hwijaya.output.CancelMsg;
import edu.illinoistech.hawk.hwijaya.output.CancelMsg2;
import edu.illinoistech.hawk.hwijaya.output.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.output.DisplayMenu2;
import edu.illinoistech.hawk.hwijaya.output.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.output.EnterPinMsg2;
import edu.illinoistech.hawk.hwijaya.output.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.output.GasPumpedMsg2;
import edu.illinoistech.hawk.hwijaya.output.InitializeData;
import edu.illinoistech.hawk.hwijaya.output.InitializeData2;
import edu.illinoistech.hawk.hwijaya.output.PayMsg;
import edu.illinoistech.hawk.hwijaya.output.PayMsg2;
import edu.illinoistech.hawk.hwijaya.output.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.output.PrintReceipt2;
import edu.illinoistech.hawk.hwijaya.output.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.output.PumpGasUnit2;
import edu.illinoistech.hawk.hwijaya.output.RejectMsg;
import edu.illinoistech.hawk.hwijaya.output.RejectMsg2;
import edu.illinoistech.hawk.hwijaya.output.ResetCounter;
import edu.illinoistech.hawk.hwijaya.output.ResetCounter2;
import edu.illinoistech.hawk.hwijaya.output.ReturnCash;
import edu.illinoistech.hawk.hwijaya.output.ReturnCash2;
import edu.illinoistech.hawk.hwijaya.output.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.output.SetPriceMsg2;
import edu.illinoistech.hawk.hwijaya.output.StopMsg;
import edu.illinoistech.hawk.hwijaya.output.StopMsg2;
import edu.illinoistech.hawk.hwijaya.output.StoreCash;
import edu.illinoistech.hawk.hwijaya.output.StoreCash2;
import edu.illinoistech.hawk.hwijaya.output.StorePin;
import edu.illinoistech.hawk.hwijaya.output.StorePin2;
import edu.illinoistech.hawk.hwijaya.output.StorePrices;
import edu.illinoistech.hawk.hwijaya.output.StorePrices2;
import edu.illinoistech.hawk.hwijaya.output.WrongPinMsg;
import edu.illinoistech.hawk.hwijaya.output.WrongPinMsg2;

/**
 * Concrete Factory class for Gas Pump 2.
 */
public class GasPumpFactory2 implements AbstractFactory {
    DataStore dataStore = new DataStore2();
    StorePrices storePrices = new StorePrices2();
    StoreCash storeCash = new StoreCash2();
    StorePin storePin = new StorePin2();
    InitializeData initializeData = new InitializeData2();
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
