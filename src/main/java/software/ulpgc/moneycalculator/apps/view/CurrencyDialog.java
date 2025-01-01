package software.ulpgc.moneycalculator.apps.view;

import software.ulpgc.moneycalculator.apps.architecture.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
