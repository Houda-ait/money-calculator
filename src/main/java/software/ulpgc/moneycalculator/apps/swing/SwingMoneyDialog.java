package software.ulpgc.moneycalculator.apps.swing;


import software.ulpgc.moneycalculator.apps.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.architecture.model.Money;
import software.ulpgc.moneycalculator.apps.view.CurrencyDialog;
import software.ulpgc.moneycalculator.apps.view.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amountField;
    private CurrencyDialog currencyDialog;

    public SwingMoneyDialog() {
        this.setLayout(new FlowLayout());
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(createAmountField());
        add(createCurrencyDialog(currencies));
        return this;
    }

    private Component createCurrencyDialog(List<Currency> currencies) {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        dialog.define(currencies);
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createAmountField() {
        JTextField textField = new JTextField();
        textField.setColumns(5);
        this.amountField = textField;
        return textField;
    }

    @Override
    public Money get() {
        return new Money(toLong(amountField.getText()), currencyDialog.get());
    }

    private long toLong(String text) {
        return Long.parseLong(text);
    }
}
