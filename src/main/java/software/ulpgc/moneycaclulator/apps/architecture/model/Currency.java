package software.ulpgc.moneycaclulator.apps.architecture.model;

public record Currency(String code, String name) {
    @Override
    public String toString() {
        return code + "-" + name;
    }
}
