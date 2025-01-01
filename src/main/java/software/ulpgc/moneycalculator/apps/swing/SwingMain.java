package software.ulpgc.moneycalculator.apps.swing;

import software.ulpgc.moneycalculator.apps.architecture.command.Command;
import software.ulpgc.moneycalculator.apps.architecture.command.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.apps.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.fixerio.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.apps.fixerio.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.apps.view.CurrencyDialog;
import software.ulpgc.moneycalculator.apps.view.MoneyDialog;
import software.ulpgc.moneycalculator.apps.view.MoneyDisplay;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public SwingMain() throws HeadlessException {
        setTitle("Money Calculator");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel moneyDialogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        moneyDialogPanel.add(createMoneyDialog());
        centerPanel.add(moneyDialogPanel);

        JPanel currencyDialogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        currencyDialogPanel.add(createCurrencyDialog());
        centerPanel.add(currencyDialogPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(toolbar());
        centerPanel.add(buttonPanel);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(createMoneyDisplay());
        centerPanel.add(resultPanel);

        add(centerPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {

        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.setFont(new Font("Serif", Font.BOLD, 16));
        button.setForeground(Color.BLUE);
        button.setToolTipText("This is an example button");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }


    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }


    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}