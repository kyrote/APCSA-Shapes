class Ellipse {

    double r1, r2;
    String color;

    Ellipse(double x, double y) {
        this.r1 = x;
        this.r2 = y;
    }

    Ellipse(double x) {
        this.r1 = x;
        this.r2 = x;
    }

    Ellipse() {
        this.r1 = 1;
        this.r2 = 1;
    }

    /* short-hand w/o overloading
        Ellipse(double... x) {
            this.r1 = x.length > 0 ? x[0] : 1;
            this.r2 = x.length > 1 ? x[1] : x[0];
        }

        void setRadius(double... x) {
            this.r1 = x.length > 0 ? x[0] : 1;
            this.r2 = x.length > 0 ? x[1] : x[0];
        }
    */

    void setRadius(double x, double y) {
        this.r1 = x;
        this.r2 = y;
    }

    void setRadius(double x) {
        this.r1 = x;
        this.r2 = x;
    }

    double[] getRadius() {
        double[] arr = { this.r1, this.r2 };
        return arr;
    }

    double getArea() {
        return Math.PI * this.r1 * this.r2;
    }

    double getCircumference() {
        // approximate within 5% if it becomes a "squashed" ellipse
        return 2 * Math.PI * Math.sqrt((Math.pow(this.r1, 2) + Math.pow(this.r2, 2)) / 2); // this is a formula used to approximate ellipse circumferences, however, it has 100% accuracy with circles.
    }

    boolean equals(Ellipse c) {
        return (this.r1 == c.r1 && this.r2 == c.r2);
    }

    public String toString() {
        String str = r1 == r2 ? "circle with radius " + r1 : "ellipse with radius " + this.r1 + " and " + this.r2; // if circle, print circle; if ellipse, print ellipse.
        return this.color != null ? this.color + " " + str : str; // if there's a color, print it with that.
    }

    /* short-hand w/o overloading
        void scale(double... x) {
            this.r1 *= x[0];
            this.r2 *= x.length > 1 ? x[1] : x[0];
        }
    */

    void scale(double x, double y) {
        this.r1 *= x;
        this.r2 *= y;
    }

    void scale(double x) {
        this.r1 *= x;
        this.r2 *= x;
    }

    void setColor(String c) {
        this.color = c;
    }

}

class Rectangle {

    double length, width;
    String color;

    Rectangle(double x, double y) {
        this.length = x;
        this.width = y;
    }

    Rectangle(double x) {
        this.length = x;
        this.width = x;
    }

    Rectangle() {
        this.length = 1;
        this.width = 1;
    }


    /* short-hand w/o overloading
        Rectangle(double... x) {
            this.length = x.length > 0 ? x[0] : 1;
            this.width = x.length > 1 ? x[1] : x[0];
        }
    */

    void setLength(double x) {
        this.length = x;
    } 

    void setWidth(double x) {
        this.width = x;
    }

    double getLength() {
        return this.length;
    }

    double getWidth() {
        return this.width;
    }

    double getArea() {
        return this.length * this.width;
    }

    double getPerimeter() {
        return this.length * 2 + this.width * 2;
    }

    boolean equals(Rectangle r) {
        return (this.length == r.length && this.width == r.width);
    }

    public String toString() {
        String str = "rectangle with length " + this.length + ", width " + this.width;
        return this.color != null ? this.color + " " + str : str; // if there's a color, print it with that.
    }

    void setColor(String c) {
        this.color = c;
    }

}

class RegularPolygon {

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
        this.length = x;
        this.sides = y;
    }

    RegularPolygon(double x) {
        this.length = x;
    }

    RegularPolygon(int y) {
        this.sides = y;
    }

    RegularPolygon() {
        this.length = 1;
        this.sides = 3;
    }

    void setSideLength(int x) {
        this.length = x;
    }

    void setNumSides(int x) {
        this.sides = x;
    }

    int getNumSides() {
        return this.sides;
    } 

    double getSideLength() {
        return this.length;
    }

    double getArea() {
        return this.sides * Math.pow(this.length, 2) * (1 / Math.tan(Math.PI / this.sides) / 4);
    }

    double getPerimeter() {
        return this.length * this.sides;
    }

    boolean equals(RegularPolygon r) {
        return (this.length == r.length && this.sides == r.sides && this.color == r.color);
    }

    void addSides(int x) {
        this.sides += x;
    }

    void addSides() {
        this.sides++;
    }

    public String toString() {
        String str;
        str = "polygon of " + this.sides + " sides with side length " + this.length; // worst case scenario; we cannot name the polygon.
        if (this.sides >= 3 && this.sides <= 20) {
            str = "regular " + shapes[this.sides - 3] + " with side length " + this.length; // sides > 4 so we search the array and add regular to the start of it.
            if (this.sides <= 4) {
                str = shapes[this.sides - 3] + " with side length " + this.length; // either it's an equilateral triangle or square.
            }
        }
        return color != null ? color + " " + str : str; // if there's a color, print it with that.
    }

    void setColor(String c) {
        this.color = c;
    }

}

class MethodExplorer {
    public static void main(String[] args) {

        /* You can test my code out here!
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
        */

    }
}
