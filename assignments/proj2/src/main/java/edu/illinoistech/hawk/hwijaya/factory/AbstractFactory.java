package edu.illinoistech.hawk.hwijaya.factory;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.output.CancelMsg;
import edu.illinoistech.hawk.hwijaya.output.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.output.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.output.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.output.InitializeData;
import edu.illinoistech.hawk.hwijaya.output.PayMsg;
import edu.illinoistech.hawk.hwijaya.output.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.output.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.output.RejectMsg;
import edu.illinoistech.hawk.hwijaya.output.ReturnCash;
import edu.illinoistech.hawk.hwijaya.output.ResetCounter;
import edu.illinoistech.hawk.hwijaya.output.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.output.StopMsg;
import edu.illinoistech.hawk.hwijaya.output.StoreCash;
import edu.illinoistech.hawk.hwijaya.output.StorePin;
import edu.illinoistech.hawk.hwijaya.output.StorePrices;
import edu.illinoistech.hawk.hwijaya.output.WrongPinMsg;

/**
 * Using abstract factory pattern, AbstractFactory interface defines methods to create
 * families of related objects without specifying their concrete classes.
 */
public interface AbstractFactory {
    DataStore getDataStore();

    StorePrices getStorePrices();

    StoreCash getStoreCash();

    StorePin getStorePin();

    InitializeData getInitializeData();

    PayMsg getPayMsg();

    DisplayMenu getDisplayMenu();

    RejectMsg getRejectMsg();

    SetPriceMsg getSetPrice();

    ResetCounter getResetCounter();

    PumpGasUnit getPumpGasUnit();

    GasPumpedMsg getGasPumpedMsg();

    StopMsg getStopMsg();

    PrintReceipt getPrintReceipt();

    CancelMsg getCancelMsg();

    WrongPinMsg getWrongPinMsg();

    ReturnCash getReturnCash();

    EnterPinMsg getEnterPinMsg();
}
