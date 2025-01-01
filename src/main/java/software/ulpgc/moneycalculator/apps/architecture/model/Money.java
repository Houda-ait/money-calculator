package software.ulpgc.moneycalculator.apps.architecture.model;

public record Money(long amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
