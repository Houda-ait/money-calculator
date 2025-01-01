package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.Currency;
import software.ulpgc.moneycalculator.ExchangeRate;
import software.ulpgc.moneycalculator.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
        private static final String BASE_CURRENCY_CODE = "EUR";

        @Override
        public ExchangeRate load(Currency from, Currency to) {
            try {
                String json = loadJson();
                LocalDate date = LocalDate.parse(new Gson().fromJson(json, JsonObject.class).get("date").getAsString());
                JsonObject ratesObject = new Gson().fromJson(json, JsonObject.class).getAsJsonObject("rates");

                if (from.code().equals(BASE_CURRENCY_CODE)) {
                    return new ExchangeRate(from, to, date, ratesObject.get(to.code()).getAsDouble());
                } else if (to.code().equals(BASE_CURRENCY_CODE)) {
                    return new ExchangeRate(from, to, date, 1 / ratesObject.get(from.code()).getAsDouble());
                } else {
                    double rateFromToEUR = 1 / ratesObject.get(from.code()).getAsDouble();
                    double rateEURToTo = ratesObject.get(to.code()).getAsDouble();
                    double rateFromToTo = rateFromToEUR * rateEURToTo;
                    return new ExchangeRate(from, to, date, rateFromToTo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private String loadJson() throws IOException {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=" + FixerAPI.key);
            try (InputStream is = url.openStream()) {
                return new String(is.readAllBytes());
            }
        }
    }