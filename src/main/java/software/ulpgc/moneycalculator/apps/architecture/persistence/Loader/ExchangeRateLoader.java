package software.ulpgc.moneycaclulator.apps.architecture.persistence.Loader;

import software.ulpgc.moneycaclulator.apps.architecture.model.Currency;
import software.ulpgc.moneycaclulator.apps.architecture.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
