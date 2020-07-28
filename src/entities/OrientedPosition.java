package entities;

public class OrientedPosition {
    private int xPos;
    private int yPos;
    private CompassPoint compassPoint;

    public OrientedPosition(int xPos, int yPos, CompassPoint compassPoint) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.compassPoint = compassPoint;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public CompassPoint getCompassPoint() {
        return compassPoint;
    }

    public void setCompassPoint(CompassPoint compassPoint) {
        this.compassPoint = compassPoint;
    }

    public String toJsonString() {
        return "{" +
                "\"xPos\":" + xPos +
                ", \"yPos\":" + yPos +
                ", \"compassPoint\": \"" + compassPoint +
                "\"}";
    }

    @Override
    public String toString() {
        return "OrientedPosition{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", compassPoint=" + compassPoint +
                '}';
    }

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
