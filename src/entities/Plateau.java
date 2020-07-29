package entities;

public class Plateau {

    private final int plateauMaxWidth;

    private final int plateauMaxHeight;

    public Plateau(int plateauMaxWidth, int plateauMaxHeight) {
        if (plateauMaxWidth >= 0 && plateauMaxHeight >= 0) {
            this.plateauMaxWidth = plateauMaxWidth;
            this.plateauMaxHeight = plateauMaxHeight;
        } else
            throw new IllegalArgumentException("Error: Both plateau limits must be bigger or equal to zero.");
    }

    public int getPlateauMaxWidth() {
        return plateauMaxWidth;
    }

    public int getPlateauMaxHeight() {
        return plateauMaxHeight;
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "plateauMaxWidth=" + plateauMaxWidth +
                ", plateauMaxHeight=" + plateauMaxHeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return plateauMaxWidth == plateau.plateauMaxWidth &&
                plateauMaxHeight == plateau.plateauMaxHeight;
    }

}