package edu.illinoistech.hawk.hwijaya.af;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.op.CancelMsg;
import edu.illinoistech.hawk.hwijaya.op.DisplayMenu;
import edu.illinoistech.hawk.hwijaya.op.EnterPinMsg;
import edu.illinoistech.hawk.hwijaya.op.GasPumpedMsg;
import edu.illinoistech.hawk.hwijaya.op.PayMsg;
import edu.illinoistech.hawk.hwijaya.op.PrintReceipt;
import edu.illinoistech.hawk.hwijaya.op.PumpGasUnit;
import edu.illinoistech.hawk.hwijaya.op.RejectMsg;
import edu.illinoistech.hawk.hwijaya.op.ReturnCash;
import edu.illinoistech.hawk.hwijaya.op.ResetCounter;
import edu.illinoistech.hawk.hwijaya.op.SetPriceMsg;
import edu.illinoistech.hawk.hwijaya.op.StopMsg;
import edu.illinoistech.hawk.hwijaya.op.StoreCash;
import edu.illinoistech.hawk.hwijaya.op.StorePin;
import edu.illinoistech.hawk.hwijaya.op.StorePrices;
import edu.illinoistech.hawk.hwijaya.op.WrongPinMsg;

/**
 * Using abstract factory pattern, AbstractFactory interface defines methods to create
 * families of related objects without specifying their concrete classes.
 */
public interface AbstractFactory {
    DataStore getDataStore();

    StorePrices getStorePrices();

    StoreCash getStoreCash();

    StorePin getStorePin();

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
