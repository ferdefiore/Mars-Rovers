package models;
/**
 * This class represents a plateau. This Plateau must have positive limits.
 * The plateau dimensions are represented with two int as Width and Height.
 * Both of them are the maximum value and represent the upper-right coordinates of the plateau.
 */
public class Plateau {

    /**
     * Int that represents the maximum width value of the plateau
     */
    private final int plateauMaxWidth;

    /**
     * Int that represents the maximum height value of the plateau
     */
    private final int plateauMaxHeight;

    /**
     * Plateau Constructor class.
     * This method check the limits of the plateau after creating it. If one of them is negative, it throw an IllegalArgumentExeption.
     *
     * @param plateauMaxWidth  Int that represents the maximum width value of the plateau
     * @param plateauMaxHeight Int that represents the maximum height value of the plateau
     */
    public Plateau(int plateauMaxWidth, int plateauMaxHeight) {
        if (plateauMaxWidth >= 0 && plateauMaxHeight >= 0) {
            this.plateauMaxWidth = plateauMaxWidth;
            this.plateauMaxHeight = plateauMaxHeight;
        } else
            throw new IllegalArgumentException("Error: Both plateau limits must be bigger or equal to zero.");
    }

    /**
     * @return int that represents plateau max width
     */
    public int getPlateauMaxWidth() {
        return plateauMaxWidth;
    }

    /**
     * @return int that represents plateau max height
     */
    public int getPlateauMaxHeight() {
        return plateauMaxHeight;
    }

    /**
     * @return String with Plateau information
     */
    @Override
    public String toString() {
        return "Plateau{" +
                "plateauMaxWidth=" + plateauMaxWidth +
                ", plateauMaxHeight=" + plateauMaxHeight +
                '}';
    }

    /**
     * @param o Object to compare with the plateau
     * @return true if every attribute of Object o is the same as the plateau
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return plateauMaxWidth == plateau.plateauMaxWidth &&
                plateauMaxHeight == plateau.plateauMaxHeight;
    }

}