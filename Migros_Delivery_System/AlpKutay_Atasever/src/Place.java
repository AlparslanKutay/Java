



    public abstract class Place {

        private double xcoordinate;
        private double ycoordinate;
        private int placeType;

        @Override
        public String toString() {
            return "xcoordinate" + xcoordinate + ",ycoordinate" + ycoordinate + ",placeType" + placeType;
        }

        public abstract void shortestDistance();
        }



