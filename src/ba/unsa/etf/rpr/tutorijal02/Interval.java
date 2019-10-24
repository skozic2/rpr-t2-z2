package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double p, k;
    private boolean pp, kp;
    public Interval(double x1, double x2, boolean b1, boolean b2){
        if(x1>x2) throw new IllegalArgumentException("");
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
    public double getP(){return p;}
    public double getK(){return k;}
    public boolean getPP(){ return pp;}
    public boolean getKP(){ return kp;}

    public boolean isNull(){
        if(p==0 && k==0 && !pp && !kp) return true;
        return false;
    }
    public boolean isIn(double t){
        if ((t>p && t<k)||(t==k && kp) || (t==p && pp)) return true;
        return false;
    }
    public Interval intersect(Interval i){
        double poc, kr;
        boolean ppoc=false , pkr=false;
        if(i.getP()>this.k || i.getK()<this.p) return new Interval();
        if(i.getP()>=this.p){
            if(i.getPP())  ppoc=true;
            poc=i.getP();
        }
        else{
            poc=this.p;
            if(this.pp) ppoc=true;
        }
        if(i.getK()<=this.k) {
            if(i.getKP()) pkr=true;
            kr=i.getK();
        }
        else{
            if(this.kp) pkr=true;
            kr=this.k;
        }
        return new Interval(poc,kr,ppoc,pkr);
    }
    public static Interval intersect(Interval i, Interval j){
        double poc, kr;
        boolean ppoc=false , pkr=false;
        if(i.getP()>j.getK() || i.getK()<j.getP()) return new Interval();
        if(i.getP()>=j.getP()){
            if(i.getPP())  ppoc=true;
            poc=i.getP();
        }
        else{
            poc=j.getP();
            if(j.getPP()) ppoc=true;
        }
        if(i.getK()<=j.getK()) {
            if(i.getKP()) pkr=true;
            kr=i.getK();
        }
        else{
            if(j.getKP()) pkr=true;
            kr=j.getK();
        }
        return new Interval(poc,kr,ppoc,pkr);
    }
    @Override
    public boolean equals(Object j){
        Interval i=(Interval)j;
        return (i.getP()==this.p && i.getK()==this.k && i.getPP()==this.pp && i.getKP()==this.kp);
    }
    @Override
    public String toString(){
        //double p=this.getP(), k=this.getK();
        //boolean pp=this.getPP(), kp=this.getKP();
        if(this.isNull()) return "()";
        if(pp){
            if(kp) return ("["+p+","+k+"]");
            return ("["+p+","+k+")");
        }
        else{
            if(kp) return ("("+p+","+k+"]");
            return ("("+p+","+k+")");
        }
    }


}
