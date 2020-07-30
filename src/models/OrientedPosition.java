package models;

import entities.CompassPoint;

/**
 * Class that represents a position and location by a combination of three attributes.
 * Two int X and Y, as coordinates. And a Cardinal point representing one of the cardinal compass points in the enum CompassPoint.
 *
 * @see CompassPoint
 */
public class OrientedPosition {
    /**
     * Int that represents coordinate X. The horizontal value in a pair of coordinates also called "abscissa"
     */
    private int xPos;

    /**
     * Int that represents coordinate Y. The vertical value in a pair of coordinates also called "ordinate"
     */
    private int yPos;

    /**
     * CardinalPoint that belongs to CompassPoint enum
     *
     * @see CompassPoint
     */
    private CompassPoint compassPoint;

    /**
     * Oriented Position class constructor
     *
     * @param xPos         Int that represents coordinate X
     * @param yPos         Int that represents coordinate Y
     * @param compassPoint CompassPoint enum represents one of the compass cardinal points
     * @see CompassPoint
     */
    public OrientedPosition(int xPos, int yPos, CompassPoint compassPoint) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.compassPoint = compassPoint;
    }

    /**
     * @return int representing OrientedPosition coordinate X
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Oriented Position coordinate X setter
     *
     * @param xPos int that will represent OrientedPosition coordinate X
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return int representing OrientedPosition coordinate Y
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * Oriented Position coordinate Y setter
     *
     * @param yPos int that will represent OrientedPosition coordinate Y
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return A valid enum element of CompassPoint
     * @see CompassPoint
     */
    public CompassPoint getCompassPoint() {
        return compassPoint;
    }

    /**
     * Oriented Position cardinal point setter
     *
     * @param compassPoint CardinalPoints enum that will represent OrientedPosition cardinal point
     * @see CompassPoint
     */
    public void setCompassPoint(CompassPoint compassPoint) {
        this.compassPoint = compassPoint;
    }


    /**
     * @return String with Oriented Position Information
     */
    @Override
    public String toString() {
        return "OrientedPosition{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", compassPoint=" + compassPoint +
                '}';
    }

    /**
     * @param o Object to compare with OrientedPosition
     * @return true if the object o in parameter is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrientedPosition that = (OrientedPosition) o;
        return xPos == that.xPos &&
                yPos == that.yPos &&
                compassPoint == that.compassPoint;
    }
}
