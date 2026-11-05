package ua.khnu.kpp;
/** Variant 8: museum catalog; approved is informational. */
public final class VariantPolicy implements CompletionPolicy {
    @Override public boolean allows(int units, int defects, boolean approved) {
        return units >= 12 && defects <= units / 4;
    }
}
