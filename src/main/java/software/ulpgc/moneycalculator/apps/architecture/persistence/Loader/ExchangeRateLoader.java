package software.ulpgc.moneycalculator.apps.architecture.persistence.Loader;

import software.ulpgc.moneycalculator.apps.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.architecture.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
