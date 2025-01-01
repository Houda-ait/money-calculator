package software.ulpgc.moneycalculator.apps.architecture.command;

import software.ulpgc.moneycalculator.apps.view.CurrencyDialog;
import software.ulpgc.moneycalculator.apps.view.MoneyDialog;
import software.ulpgc.moneycalculator.apps.view.MoneyDisplay;
import software.ulpgc.moneycalculator.apps.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculator.apps.architecture.model.Money;
import software.ulpgc.moneycalculator.apps.architecture.persistence.Loader.ExchangeRateLoader;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money((long) (money.amount()*exchangeRate.rate()), currency);

        moneyDisplay.show(result);
    }
}
