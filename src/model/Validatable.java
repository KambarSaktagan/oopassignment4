package model;

public interface Validatable {
    void validate();

    default boolean isValid() {
        try {
            validate();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    static void requireNonNull(Object obj, String msg) {
        if (obj == null) throw new IllegalArgumentException(msg);
    }
}
