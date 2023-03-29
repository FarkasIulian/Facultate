package org.example;

import java.time.LocalDate;

public class Angajat{
    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private Float salariu;

    public Angajat() {}

    public Angajat(String nume, String post, LocalDate data_angajarii, Float salariu) {
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return nume+", " + post + ", " + data_angajarii + ", " + salariu;
    }

    public String getNume() {
        return nume;
    }

    public String getPost() {
        return post;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public Float getSalariu() {
        return salariu;
    }


}
