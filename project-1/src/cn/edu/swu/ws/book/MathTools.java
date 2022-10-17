package cn.edu.swu.ws.book;

public final class MathTools {

    public final static double PI = 3.1415926;

    public static double area(double radius) {
        return Math.pow(radius, 2) * MathTools.PI;
    }

}
