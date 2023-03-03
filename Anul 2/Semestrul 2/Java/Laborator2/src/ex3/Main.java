package ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //sb.delete
        //sir.substring(a,n) sau sir.substring(n)
        String sir, ss, sirfinal;
        int pos,x;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti un sir: ");
        sir = scan.nextLine();
        System.out.println("Introduceti sir-ul pe care doriti sa-l introduceti in primul sir: ");
        ss = scan.nextLine();
        System.out.println("Introduceti pozitia la care doriti sa inserati noul sir: ");
        pos = scan.nextInt();
        sirfinal = sir.substring(0, pos) + ss + sir.substring(pos);
        System.out.println("Sirul final dupa insertie: ");
        System.out.println(sirfinal);
        System.out.println("De la ce pozitie doriti sa stergeti: ");
        pos = scan.nextInt();
        System.out.println("Cate caractere doriti sa stergeti: ");
        x = scan.nextInt();
        StringBuilder sb = new StringBuilder(sirfinal);
        sb.delete(pos,x);
        System.out.println("Sirul final dupa stergere: ");
        System.out.println(sb);
    }
}
