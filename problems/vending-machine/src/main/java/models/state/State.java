package models.state;

import models.VendingMachine;

public interface State {
    void pushInsertCoinButton(VendingMachine vendingMachine) throws Exception;

    void insertCoin(int coin, VendingMachine vendingMachine) throws Exception;

    void selectItemButton(VendingMachine vendingMachine) throws Exception;

    void selectItem(String item, VendingMachine vendingMachine) throws Exception;

    void dispenseButton(VendingMachine vendingMachine) throws Exception;

    void dispense(VendingMachine vendingMachine) throws Exception;

    void returnAllMoney(VendingMachine vendingMachine) throws Exception;

    void returnChange(VendingMachine vendingMachine) throws Exception;

    void cancel(VendingMachine vendingMachine) throws Exception;
}
