package software.ulpgc.moneycaclulator.apps.view;

import software.ulpgc.moneycaclulator.apps.architecture.model.Currency;
import software.ulpgc.moneycaclulator.apps.architecture.model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
