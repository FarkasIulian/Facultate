package org.example.ex2;

public class PerecheNumere {
    private int a, b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public PerecheNumere() {
    }

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }

    public int fibonnaci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return fibonnaci(n - 1) + fibonnaci(n - 2);
    }

    public boolean areFib() {
        int[] valori = new int[30];
        for (int i = 0; i < valori.length; i++)
            valori[i] = fibonnaci(i);
        for (int i = 0; i < valori.length - 1; i++)
            if (this.a == valori[i] && this.b == valori[i + 1])
                return true;
        return false;
    }

    public int leastCommon() {
        int x = a, y = b;
        while (x != y) {
            if (x > y)
                x -= y;
            else
                y -= x;
        }
        return (a * b) / x;
    }

    public int cifre(int n, int opt) {
        int i = 0;
        if (opt == 0)
            while (n / 10 != 0) {
                i++;
                n /= 10;
            }
        else{
            while(n/10!=0){
                if(n%10%2==0)
                    i++;
                n/=10;
            }
        }
        return i;
    }

    public boolean nrcifre() {
        int cifre1, cifre2;
        cifre1 = cifre(a,0); // 0 - toate numerele, 1 - nr pare
        cifre2 = cifre(b,0);
        if (cifre1 == cifre2)
            return true;
        return false;
    }
    public boolean nrpare(){
        int cifre1, cifre2;
        cifre1 = cifre(a,1); // 0 - toate numerele, 1 - nr pare
        cifre2 = cifre(b,1);
        if (cifre1 == cifre2)
            return true;
        return false;
    }
}
