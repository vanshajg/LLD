package models.state;

import models.VendingMachine;

public class MoneyInsertState implements State {

    @Override
    public void pushInsertCoinButton(VendingMachine vendingMachine) {
        throw new RuntimeException("You can't insert coin twice");
    }

    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.getCoins().add(coin);
    }

    @Override
    public void selectItemButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectItem(String item, VendingMachine vendingMachine) {
        throw new RuntimeException("You can't select item before inserting coin");
    }

    @Override
    public void dispenseButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        throw new RuntimeException("You can't dispense before selecting item");
    }

    @Override
    public void returnAllMoney(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void cancel(VendingMachine vendingMachine) {

    }
}
