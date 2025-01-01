package software.ulpgc.moneycalculator.apps.view;

import software.ulpgc.moneycalculator.apps.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.architecture.model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
