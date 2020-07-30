package entities;

/**
 * The enum CompassPoint represents the fourth principal cardinal points.
 * It representation links each cardinal point with his first letter.
 * North: N
 * South: S
 * East: E
 * West: W
 */
public enum CompassPoint {
    N {
        /**
         * @return W as CompassPoint
         */
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.W;
        }

        /**
         * @return E as CompassPoint
         */
        public CompassPoint turn90DegreeRight() {
            return CompassPoint.E;
        }
    },
    E {
        /**
         * @return N as CompassPoint
         */
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.N;
        }

        /**
         * @return S as CompassPoint
         */
        public CompassPoint turn90DegreeRight() {
            return CompassPoint.S;
        }
    },
    S {
        /**
         * @return E as CompassPoint
         */
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.E;
        }

        /**
         * @return W as CompassPoint
         */
        public CompassPoint turn90DegreeRight() {
            return CompassPoint.W;
        }
    },
    W {
        /**
         * @return S as CompassPoint
         */
        public CompassPoint turn90DegreeLeft() {
            return CompassPoint.S;
        }

        /**
         * @return N as CompassPoint
         */
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
     * Each possible Compass Point can execute this method to calculate a new cardinal point after performing a 90 degree turn left from the actual cp.
     *
     * @return Returns the resultant Cardinal Point
     */
    public abstract CompassPoint turn90DegreeLeft();
}
