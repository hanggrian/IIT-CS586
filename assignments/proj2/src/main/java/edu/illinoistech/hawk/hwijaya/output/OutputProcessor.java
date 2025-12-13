package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.factory.AbstractFactory;
import edu.illinoistech.hawk.hwijaya.data.DataStore;

/**
 * Using output processor pattern, OutputProcessor class acts as an intermediary
 * between the MDA-EFSM and the output actions.
 */
public class OutputProcessor {
    StorePrices storePrices;
    StoreCash storeCash;
    StorePin storePin;
    PayMsg payMsg;
    InitializeData initializeData;
    ResetCounter resetCounter;
    PumpGasUnit pumpGasUnit;
    GasPumpedMsg gasPumpedMsg;
    StopMsg stopMsg;
    PrintReceipt printReceipt;
    EnterPinMsg enterPinMsg;
    DataStore dataStore;
    DisplayMenu displayMenu;
    RejectMsg rejectMsg;
    CancelMsg cancelMsg;
    ReturnCash returnCash;
    WrongPinMsg wrongPinMsg;
    SetPriceMsg setPriceMsg;

    public OutputProcessor(AbstractFactory abstractFactory) {
        dataStore = abstractFactory.getDataStore();
        storePrices = abstractFactory.getStorePrices();
        storeCash = abstractFactory.getStoreCash();
        storePin = abstractFactory.getStorePin();
        payMsg = abstractFactory.getPayMsg();
        initializeData = abstractFactory.getInitializeData();
        pumpGasUnit = abstractFactory.getPumpGasUnit();
        gasPumpedMsg = abstractFactory.getGasPumpedMsg();
        stopMsg = abstractFactory.getStopMsg();
        printReceipt = abstractFactory.getPrintReceipt();
        enterPinMsg = abstractFactory.getEnterPinMsg();
        displayMenu = abstractFactory.getDisplayMenu();
        rejectMsg = abstractFactory.getRejectMsg();
        cancelMsg = abstractFactory.getCancelMsg();
        returnCash = abstractFactory.getReturnCash();
        wrongPinMsg = abstractFactory.getWrongPinMsg();
        setPriceMsg = abstractFactory.getSetPrice();
        resetCounter = abstractFactory.getResetCounter();

        initializeData.initialize(dataStore);
        gasPumpedMsg.initialize(dataStore);
        printReceipt.initialize(dataStore);
        pumpGasUnit.initialize(dataStore);
        resetCounter.initialize(dataStore);
        returnCash.initialize(dataStore);
        setPriceMsg.initialize(dataStore);
        storeCash.initialize(dataStore);
        storePin.initialize(dataStore);
        storePrices.initialize(dataStore);
        wrongPinMsg.initialize(dataStore);
    }

    public void storePrices() {
        storePrices.storePrices();
    }

    public void storeCash() {
        storeCash.storeCash();
    }

    public void storePin() {
        storePin.storePin();
    }

    public void payMsg() {
        payMsg.payMsg();
    }

    public void initializeData() {
        initializeData.initializeData();
    }

    public void enterPinMsg() {
        enterPinMsg.enterPinMsg();
    }

    public void displayMenu() {
        displayMenu.displayMenu();
    }

    public void rejectMsg() {
        rejectMsg.rejectMsg();
    }

    public void cancelMsg() {
        cancelMsg.cancelMsg();
    }

    public void returnCash() {
        returnCash.returnCash();
    }

    public void wrongPinMsg() {
        wrongPinMsg.wrongPinMsg();
    }

    public void setPrice(int g) {
        setPriceMsg.setPrice(g);
    }

    public void resetCounter() {
        resetCounter.resetCounter();
    }

    public void pumpGasUnit() {
        pumpGasUnit.pumpGasUnit();
    }

    public void gasPumpedMsg() {
        gasPumpedMsg.gasPumpedMsg();
    }

    public void printReceipt() {
        printReceipt.printReceipt();
    }
}
