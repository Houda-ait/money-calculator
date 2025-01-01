package software.ulpgc.moneycalculator.apps.architecture.model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {
}
