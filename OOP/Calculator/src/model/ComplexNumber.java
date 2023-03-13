package model;

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }
    public ComplexNumber(){
        this(0, 0);
    }
    public ComplexNumber getConjugate(){
        return new ComplexNumber(re, -im);
    }

    public ComplexNumber getOpposite(){
        return new ComplexNumber(-re, -im);
    }

    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public void setRe(double re) {
        this.re = re;
    }

    @Override
    public String toString() {
        if(im==0)
            return String.valueOf(re);
        if(re==0)
            return im+"i";
        String sign = (im>0)?"+":"";
        return "("+re+sign+im+"i)";
    }
}
