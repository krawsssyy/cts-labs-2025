/*
// refactor the code to adhere to LSP

import java.util.*;
interface Shape {
    Double calculateArea();
    Double calculateVolume();
}

class Sphere implements Shape {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() { return 4 * Math.PI * this.radius * this.radius; }
    @Override
    public Double calculateVolume() { return 4/3 * Math.PI * this.radius * this.radius * this.radius;}
}

class SquarePyramid implements Shape {
    double baselength;
    double height;

    public SquarePyramid(double baselength, double height) {
        this.height = height;
        this.baselength = baselength;
    }

    @Override
    public Double calculateArea() {
        double inner = this.baselength * this.baselength /4 + this.height * this.height;
        return this.baselength * this.baselength + 2 * this.baselength * Math.sqrt(inner);
    }
    @Override
    public Double calculateVolume() { return this.baselength * this.baselength * this.height / 3; }


}

class Square implements Shape {
    double length;

    public Square(double length) { this.length = length; }

    @Override
    public Double calculateArea() { return this.length * this.length;}
    @Override
    public Double calculateVolume() {
        return 0d;
    }
}

class Circle implements Shape{
    double radius;
    public Circle(double radius) {this.radius =radius;}
    @Override public Double calculateArea() { return this.radius * this.radius;}
    @Override public Double calculateVolume() {
        return 0d;
    }
}

public class LSP {
    public void showcaseAreasAndVolumes(List<Shape> shapes) {
        for(Shape s:shapes)
            System.out.println("Area: " + s.calculateArea() + "; Volume: " + s.calculateVolume());
    }
}
*/

import java.util.*;

interface Shape2D {
    Double calculateArea();
}

interface Shape3D {
    Double calculateArea();
    Double calculateVolume();
}

class Sphere implements Shape3D {
    Double radius;

    public Sphere(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    @Override
    public Double calculateVolume() {
        return 4 / 3 * Math.PI * this.radius * this.radius * this.radius;
    }
}

class SquarePyramid implements Shape3D {
    Double baseLength, height;

    public SquarePyramid(Double baseLength, Double height) {
        this.height = height;
        this.baseLength = baseLength;
    }

    @Override
    public Double calculateArea() {
        Double inner = this.baseLength * this.baseLength / 4 + this.height * this.height;
        return this.baseLength * this.baseLength + 2 * this.baseLength * Math.sqrt(inner);
    }

    @Override
    public Double calculateVolume() {
        return this.baseLength * this.baseLength * this.height / 3;
    }


}

class Square implements Shape2D {
    Double length;

    public Square(Double length) {
        this.length = length;
    }

    @Override
    public Double calculateArea() {
        return this.length * this.length;
    }
}

class Circle implements Shape2D {
    Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return this.radius * this.radius;
    }

}

public class LSP {

    public void showcase2DShapes(List<Shape2D> shapes) {
        for (Shape2D shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }

    public void showcase3DShapes(List<Shape3D> shapes) {
        for (Shape3D shape : shapes) {
            System.out.println("Area: " + shape.calculateArea() + "; Volume: " + shape.calculateVolume());
        }
    }
}