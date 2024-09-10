# Shapes (Documentation)
![Java](https://badgen.net/badge/Language/Java/yellow) ![APCSA](https://badgen.net/badge/Class/AP%20Computer%20Science%20A/orange) ![Justin Phu](https://badgen.net/badge/Made%20By/Justin%20Phu/red)

## Why did you create this?

> I created this simple Java application for my AP Computer Science A class to make shape classes and utilize methods with them!

## What shapes can be created?
### Ellipse 
You can create an ellipse object by calling:
```
Ellipse e = new Ellipse(double r1, double r2); // (1, 1) is default
```
Methods:
```
e.setRadius(double r1, double r2); // r2 is optional
e.getRadius(); // returns double[] => [r1, r2]
e.getArea();
e.getCircumference();
e.equals(Ellipse e); // checks for equal radii
e.toString(); // (color) circle/ellipse with radius ... (and ...)
e.scale(double s1, double s2); // s2 is optional
e.setColor(String c);
```

### Rectangle 
You can create an rectangle object by calling:
```
Rectangle r = new Rectangle(double len, double wid); // (1, 1) is default
```
Methods:
```
r.setLength(double len);
r.setWidth(double wid);
r.getLength();
r.getWidth();
r.getArea();
r.getPerimeter();
r.equals(Rectangle r);
r.toString(); // (color) rectangle with length ...
r.setColor(String c);
```

### RegularPolygon 
You can create an regular polygon object by calling:
```
RegularPolygon r = new RegularPolygon(int sides, double len); // (3, 1) is default
```
Methods:
```
r.setSideLength(double len);
r.setNumSides(int sides);
r.getNumSides();
r.getSideLength();
r.getArea();
r.getPerimeter();
r.equals(RegularPolygon r);
r.addSides(int sides); // sides is optional
r.toString() // (color) regular polygon_name with side length ...
r.setColor(String c);
```
