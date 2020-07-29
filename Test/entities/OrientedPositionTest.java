package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrientedPositionTest {

    OrientedPosition orientedPosition = new OrientedPosition(5, 5, CompassPoint.N);

    @Test
    void toJsonString() {
        Assertions.assertEquals(orientedPosition.toJsonString(),
                "{" +
                        "\"xPos\":" + orientedPosition.getXPos() +
                        ", \"yPos\":" + orientedPosition.getYPos() +
                        ", \"compassPoint\": \"" + orientedPosition.getCompassPoint() +
                        "\"}");
    }
}