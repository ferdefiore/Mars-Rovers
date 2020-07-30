package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompassPointTest {

    @Test
    void whenNorthTurn90LeftAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.N.turn90DegreeLeft(), CompassPoint.W);
    }

    @Test
    void whenNorthTurn90RightAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.N.turn90DegreeRight(), CompassPoint.E);
    }

    @Test
    void whenSouthTurn90LeftAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.S.turn90DegreeLeft(), CompassPoint.E);
    }

    @Test
    void whenSouthTurn90RightAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.S.turn90DegreeRight(), CompassPoint.W);
    }

    @Test
    void whenEastTurn90LeftAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.E.turn90DegreeLeft(), CompassPoint.N);
    }

    @Test
    void whenEastTurn90RightAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.E.turn90DegreeRight(), CompassPoint.S);
    }

    @Test
    void whenWestTurn90LeftAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.W.turn90DegreeLeft(), CompassPoint.S);
    }

    @Test
    void whenWestTurn90RightAndGetNextCardinalPoint() {
        Assertions.assertEquals(CompassPoint.W.turn90DegreeRight(), CompassPoint.N);
    }
}