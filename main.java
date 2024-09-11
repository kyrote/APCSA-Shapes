class MethodExplorer {

    public static class Ellipse {

        double r1, r2;
        String color;

        Ellipse(double x, double y) {
            r1 = x;
            r2 = y;
        }

        Ellipse(double x) {
            r1 = x;
            r2 = x;
        }

        Ellipse() {
            r1 = 1;
            r2 = 1;
        }

        /*
            short-hand w/o overloading
            Ellipse(double... x) {
                r1 = x.length > 0 ? x[0] : 1;
                r2 = x.length > 1 ? x[1] : x[0];
            }
              
            void setRadius(double... x) {
                r1 = x.length > 0 ? x[0] : 1;
                r2 = x.length > 0 ? x[1] : x[0];
            }
        */

        void setRadius(double x, double y) {
            r1 = x;
            r2 = y;
        }

        void setRadius(double x) {
            r1 = x;
            r2 = x;
        }

        double[] getRadius() {
            double[] arr = { r1, r2 };
            return arr;
        }

        double getArea() {
            return Math.PI * r1 * r2;
        }

        double getCircumference() {
            // approximate within 5% if it becomes a "squashed" ellipse
            return 2 * Math.PI * Math.sqrt((Math.pow(r1, 2) + Math.pow(r2, 2)) / 2); // this is a formula used to approximate ellipse circumferences, however, it has 100% accuracy for circles.
        }

        boolean equals(Ellipse c) {
            return (r1 == c.r1 && r2 == c.r2 && color == c.color);
        }

        public String toString() {
            String str = r1 == r2 ? "circle with radius " + r1 : "ellipse with radius " + r1 + " and " + r2; // if circle, print circle; if ellipse, print ellipse.
            return color != null ? color + " " + str : str; // if there's a color, print it with that.
        }

        /*
            short-hand w/o overloading
            void scale(double... x) {
                r1 *= x[0];
                r2 *= x.length > 1 ? x[1] : x[0];
            }
        */

        void scale(double x, double y) {
            r1 *= x;
            r2 *= y;
        }

        void scale(double x) {
            r1 *= x;
            r2 *= x;
        }

        void setColor(String c) {
            color = c;
        }

    }

    public static class Rectangle {

        double length, width;
        String color;

        Rectangle(double x, double y) {
            length = x;
            width = y;
        }

        Rectangle(double x) {
            length = x;
            width = x;
        }

        Rectangle() {
            length = 1;
            width = 1;
        }

        /*
            short-hand w/o overloading
            Rectangle(double... x) {
                length = x.length > 0 ? x[0] : 1;
                width = x.length > 1 ? x[1] : x[0];
            }
        */

        void setLength(double x) {
            length = x;
        }

        void setWidth(double x) {
            width = x;
        }

        double getLength() {
            return length;
        }

        double getWidth() {
            return width;
        }

        double getArea() {
            return length * width;
        }

        double getPerimeter() {
            return length * 2 + width * 2;
        }

        boolean equals(Rectangle r) {
            return (length == r.length && width == r.width && color == r.color);
        }

        public String toString() {
            String str = "rectangle with length " + length + ", width " + width;
            return color != null ? color + " " + str : str; // if there's a color, print it with that.
        }

        void setColor(String c) {
            color = c;
        }

    }

    public static class RegularPolygon {

        String[] shapes = {
            "equilateral triangle",
            "square",
            "pentagon",
            "hexagon",
            "heptagon",
            "octagon",
            "nonagon",
            "hendecagon",
            "tridecagon",
            "tetradecagon",
            "pentadecagon",
            "hexadecagon",
            "heptadecagon",
            "octadecagon",
            "enneadecagon",
            "icosihenagon"
        };

        double length;
        int sides;
        String color;

        RegularPolygon(int y, double x) {
            length = x;
            sides = y;
        }

        RegularPolygon(double x) {
            length = x;
        }

        RegularPolygon(int y) {
            sides = y;
        }

        RegularPolygon() {
            length = 1;
            sides = 3;
        }

        void setSideLength(int x) {
            length = x;
        }

        void setNumSides(int x) {
            sides = x;
        }

        int getNumSides() {
            return sides;
        }

        double getSideLength() {
            return length;
        }

        double getArea() {
            return sides * Math.pow(length, 2) * (1 / Math.tan(Math.PI / sides) / 4);
        }

        double getPerimeter() {
            return length * sides;
        }

        boolean equals(RegularPolygon r) {
            return (length == r.length && sides == r.sides && color == r.color);
        }

        void addSides(int x) {
            sides += x;
        }

        void addSides() {
            sides++;
        }

        public String toString() {
            String str;
            str = "polygon of " + sides + " sides with side length " + length; // worst case scenario; we cannot name the polygon.
            if (sides >= 3 && sides <= 20) {
                str = "regular " + shapes[sides - 3] + " with side length " + length; // sides > 4 so we search the array and add regular to the start of it.
                if (sides <= 4) {
                    str = shapes[sides - 3] + " with side length " + length; // either it's an equilateral triangle or square.
                }
            }
            return color != null ? color + " " + str : str; // if there's a color, print it with that.
        }

        void setColor(String c) {
            color = c;
        }

    }

    public static void main(String[] args) {

        // You can test my code out here!

        // Rectangle work
        Rectangle rect = new Rectangle(5, 10);
        System.out.println(rect.toString()); // (rectangle with length 5.0, width 10.0)

        rect.setColor("blue");
        System.out.println(rect.toString()); // final state (blue rectangle with length 5.0, width 10.0)

        double area = rect.getArea();
        System.out.println("The area of the rectangle is: " + area); // (The area of the rectangle is: 50.0)

        // Circle work
        Ellipse circ = new Ellipse(3);
        System.out.println(circ.toString()); // (circle with radius 3.0)

        circ.scale(2);
        System.out.println(circ.toString()); // (circle with radius 6.0)

        circ.scale(2, 3);
        System.out.println(circ.toString()); // final state (ellipse with radius 12.0 and 18.0)

    }

}
