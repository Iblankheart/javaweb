package cn.edu.swu.ws.book;

public final class Complex {
    private double real;
    private double im;

    Complex(double real, double im) {
        this.real = real;
        this.im = im;
    }

    public double getReal() {
        return this.real;
    }

    public void setReal(double r) {
        if (r > 0) {
            this.real = r;
        } else {
            throw new IllegalArgumentException("必须位正数");
        }
    }

    public double getIm() {
        return this.im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public Complex add(Complex b) {
        return new Complex(this.real + b.real,  this.im + b.im);
    }

    public Complex sub(Complex b) {
        return new Complex(this.real - b.real,  this.im - b.im);
    }

}
