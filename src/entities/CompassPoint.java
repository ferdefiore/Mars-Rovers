package entities;


public enum CompassPoint {
    N {
        public CompassPoint turn90DegreeLeft() { return CompassPoint.W; }

        public CompassPoint turn90DegreeRight() { return CompassPoint.E; }
    },
    E {
        public CompassPoint turn90DegreeLeft() { return CompassPoint.N; }

        public CompassPoint turn90DegreeRight() {
            return CompassPoint.S;
        }
    },
    S {
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.E;
        }

        public CompassPoint turn90DegreeRight() {
            return CompassPoint.W;
        }
    },
    W {
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.S;
        }

        public CompassPoint turn90DegreeRight() {
            return CompassPoint.N;
        }
    };


    /**
     * Each possible Compass Point can execute this method to calculate a new cardinal point after performing a 90 degree turn right from the actual cp.
     *
     * @return Returns the resultant Cardinal Point
     */
    public abstract CompassPoint turn90DegreeRight();

    /**
     * Each possible Compass Point can execute this method to calculatea new cardinal point after performing a 90 degree turn right from the actual cp.
     *
     * @return Returns the resultant Cardinal Point
     */
    public abstract CompassPoint turn90DegreeLeft();
}
