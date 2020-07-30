package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlateauTest {

    @Test
    void plateauWidthLimitValidation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Plateau(-1, 1));
    }

    @Test
    void plateauHeightLimitValidation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Plateau(1, -1));
    }

    @Test
    void plateauValidLimitsValidation() {
        Assertions.assertDoesNotThrow(() -> new Plateau(1, 1));
    }
}