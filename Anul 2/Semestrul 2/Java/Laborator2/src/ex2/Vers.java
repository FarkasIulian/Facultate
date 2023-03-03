package ex2;

import java.util.StringTokenizer;

public class Vers {
    private String v;

    public Vers(String v) {
        this.v = v;
    }

    public String getV() {
        return v;
    }
    public int cuvinte(){
        StringTokenizer word = new StringTokenizer(this.v);
        return word.countTokens();
    }
    public int vocale(){
        int count=0;
        for(int i=0;i<this.v.length();i++){
            if(this.v.charAt(i) == 'a' || this.v.charAt(i) == 'e' || this.v.charAt(i) == 'i' || this.v.charAt(i) == 'o' || this.v.charAt(i) == 'u')
                count++;
        }
        return count;
    }
    public char cuvFinal(String selectie){
        if(this.v.endsWith(selectie))
            return '*';
        return ' ';
    }
    public boolean majuscule(){
        double random = Math.random();
        System.out.println(random);
        if(random <0.1)
            return true;
        return false;
    }
}
