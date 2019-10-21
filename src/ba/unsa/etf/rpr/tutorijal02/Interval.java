package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double p, k;
    private boolean pp, kp;
    public Interval(double x1, double x2, boolean b1, boolean b2){
        if(x1>x2) throw IllegalArgumentException//izbaciti izuzetak
        p=x1;
        k=x2;
        pp=b1;
        kp=b2;
    }
    public Interval(){
        p=0;
        k=0;
        pp=false;
        kp=false;
    }
    public boolean isNull(){
        if(p==0 && k==0 && pp==false && kp==false) return true;
        return false;
    }
    public boolean isIn(double t){
        if ((t>p && t<k)||(t==k && kp==true) || (t==p && pp=true)) return true;
        return false;
    }
    public Interval intersect(Interval i){

    }



}
