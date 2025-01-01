package software.ulpgc.moneycalculator.apps.swing;

import software.ulpgc.moneycalculator.apps.architecture.model.Money;
import software.ulpgc.moneycalculator.apps.view.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
