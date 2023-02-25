package exercitiul4;

import java.util.Random;
//cel mai mare divizor comun
public class Main {
    public static void main(String[] args) {
        int x,y;
        Random rand = new Random();
        do {
            x = rand.nextInt(30);
            y = rand.nextInt(30);
        }while(x==0 || y == 0);
        System.out.print("Cel mai mare divizor comun al numerelor " + x + " " + y + " este: ");
        while(x!=y){
            if(x>y)
                x-=y;
            else y-=x;
        }
        System.out.print(x);
    }
}
