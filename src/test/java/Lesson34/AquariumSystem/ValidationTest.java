package Lesson34.AquariumSystem;


import Lesson34.AquariumSystem.validation.FishValidator;
import Lesson34.AquariumSystem.validation.WaterChangeValidator;
import Lesson34.AquariumSystem.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {


    @Test
    void waterChange_shouldFail_onEmptyNote() {
        assertThrows(ValidationException.class, () -> {
            WaterChangeValidator.validate("");
        });
    }

    @Test
    void fishHealth_shouldFail_onTooLongNote() {
        String longNote = "x".repeat(100);

        assertThrows(ValidationException.class, () -> {
            FishValidator.validateHealthNote(longNote);
        });
    }

    @Test
    void fishHealth_shouldPass_validNote() {
        assertDoesNotThrow(() -> {
            FishValidator.validateHealthNote("Ser sund ud");
        });
    }
}