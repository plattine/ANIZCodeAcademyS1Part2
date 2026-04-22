package Lesson34.AquariumSystem;

import Lesson34.AquariumSystem.controller.AquariumController;
import Lesson34.AquariumSystem.interfaces.Aquarium;
import Lesson34.AquariumSystem.simpleaquarium.SimpleAquarium;
import Lesson34.AquariumSystem.interfaces.Fish;
import Lesson34.AquariumSystem.simpleaquarium.SimpleFish;
import Lesson34.AquariumSystem.model.WaterQuality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AquariumControllerTest {


    @Test
    void addFish_shouldIncreaseListSize() {
        Aquarium aquarium = new SimpleAquarium();
        AquariumController controller = new AquariumController(aquarium);

        controller.addFish(new SimpleFish("Nemo"));

        assertEquals(1, controller.getFishList().size());
    }

    @Test
    void removeFish_shouldDecreaseListSize() {
        Aquarium aquarium = new SimpleAquarium();
        AquariumController controller = new AquariumController(aquarium);

        controller.addFish(new SimpleFish("Nemo"));
        controller.removeFish(0);

        assertEquals(0, controller.getFishList().size());
    }

    @Test
    void registerFishHealth_shouldNotCrash() {
        Aquarium aquarium = new SimpleAquarium();
        AquariumController controller = new AquariumController(aquarium);

        Fish fish = new SimpleFish("Nemo");

        assertDoesNotThrow(() ->
                controller.registerFishHealth(fish, "Ser sund ud")
        );
    }

    @Test
    void changeWater_shouldWork() {
        Aquarium aquarium = new SimpleAquarium();
        AquariumController controller = new AquariumController(aquarium);

        assertDoesNotThrow(() ->
                controller.changeWater("30% skift", WaterQuality.GOOD)
        );
    }
}