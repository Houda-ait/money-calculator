package software.ulpgc.moneycaclulator.apps.architecture.persistence.Loader;

import software.ulpgc.moneycaclulator.apps.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
