package ex4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoane {
    private String cnp, nume;

    public Persoane(String nume, String cnp) {
        this.cnp = cnp;
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        LocalDate actual = LocalDate.now();
        String nastere = null;
        if (Character.getNumericValue(cnp.charAt(0)) == 1 || Character.getNumericValue(cnp.charAt(0)) == 2)
            nastere = "19" + cnp.charAt(1) + cnp.charAt(2)+"-";
        else
            nastere = "20" + cnp.charAt(1) + cnp.charAt(2)+"-";
        for(int i=3;i<=6;i++) {
            if(i==5)
                nastere += "-";
            nastere += cnp.charAt(i);

        }
        System.out.println("Data nasterii: " + nastere);
        LocalDate trecut = LocalDate.parse(nastere);
        return (int) ChronoUnit.YEARS.between(trecut,actual);
    }
}
