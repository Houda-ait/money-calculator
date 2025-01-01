package software.ulpgc.moneycaclulator.apps.view;

import software.ulpgc.moneycaclulator.apps.architecture.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
