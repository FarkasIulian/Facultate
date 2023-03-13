package ex1;

public class Parabola {
    private int a,b,c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString(){
        return a + "*x^2 + (" + b + ")*x + (" + c + ")";
    }

    public double[] varf(){
        double[] coordonate = new double[2];
        coordonate[0] = -((double)b/(2*(double)a));
        coordonate[1] = (-((double)b*(double)b)+4*(double)a*(double)c)/(4*(double)a);
        return coordonate;
    }
    public double[] mijloc(Parabola aux){
        double[] coordonate = new double[2];
        coordonate[0] = (varf()[0] + aux.varf()[0])/2;
        coordonate[1] = (varf()[1] + aux.varf()[1])/2;
        return coordonate;
    }
    public static double[] mijlocS(Parabola aux1,Parabola aux2){
        double[] coordonate = new double[2];
        coordonate[0] = (aux1.varf()[0] + aux2.varf()[0])/2;
        coordonate[1] = (aux1.varf()[1] + aux2.varf()[1])/2;
        return coordonate;
    }

    public double lungime(Parabola aux){
        double l;
        l = Math.sqrt((Math.hypot(aux.varf()[0],-varf()[0]) + Math.hypot(aux.varf()[1], -varf()[1])));
        return l;
    }
    public static double lungimeS(Parabola aux1, Parabola aux2){
        double l;
        l = Math.sqrt((Math.hypot(aux2.varf()[0],-aux1.varf()[0]) + Math.hypot(aux2.varf()[1], -aux1.varf()[1])));
        return l;
    }
}
