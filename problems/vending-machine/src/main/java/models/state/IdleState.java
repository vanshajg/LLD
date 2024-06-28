package models.state;

import models.VendingMachine;

public class IdleState implements State {

    @Override
    public void pushInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new MoneyInsertState());
    }

    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        throw new RuntimeException("Cannot accept coins in idle state");
    }

    @Override
    public void selectItemButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectItem(String item, VendingMachine vendingMachine) {
        throw new RuntimeException("Cannot select item in idle state");
    }

    @Override
    public void dispenseButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        throw new RuntimeException("Cannot dispense in idle state");
    }

    @Override
    public void returnAllMoney(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        throw new RuntimeException("Cannot cancel in idle state");
    }
}
