package software.ulpgc.moneycalculator.apps.architecture.persistence.Loader;

import software.ulpgc.moneycalculator.apps.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
