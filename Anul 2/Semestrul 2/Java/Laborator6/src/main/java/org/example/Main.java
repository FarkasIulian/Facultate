package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Main {

    public static void scriere(List<Angajat> angajatList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/angajati.json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.writeValue(file, angajatList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajat> lista = mapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Angajat> angajatList = citire();
        int an = LocalDate.now().getYear() - 1;
        System.out.println("1.Toti angajatii:");
        angajatList.forEach(System.out::println);
        System.out.println("\n2.Angajatii cu salariu peste 2500 RON:\n".toUpperCase());
        angajatList
                .stream()
                .filter((Angajat a) -> a.getSalariu() >= 2500)
                .forEach(System.out::println);
        List<Angajat> angajatiSefi = angajatList
                .stream()
                .filter((a) -> a.getData_angajarii().getMonthValue() == 4 && a.getData_angajarii().getYear() == an)
                .filter((a) -> a.getPost().toLowerCase().contains("sef") || a.getPost().toLowerCase().contains("director"))
                .collect(Collectors.toList());
        System.out.println("\n3.Angajatii din luna aprilie, anul trecut, sefi sau directori:\n".toUpperCase());
        angajatiSefi.forEach(System.out::println);
        System.out.println("\n4.Angajatii descrescator dupa salariu, care nu au fct de conducere:\n".toUpperCase());
        angajatList
                .stream()
                .filter((a) -> !a.getPost().toLowerCase().contains("sef") && !a.getPost().toLowerCase().contains("director"))
                /* .sorted((a,b)->{ // o varianta mai lunga :)
                     if(a.getSalariu()<b.getSalariu())
                         return 1;
                     else if(a.getSalariu() > b.getSalariu())
                         return -1;
                     return 0;
                 })*/
                .sorted((a, b) -> b.getSalariu().compareTo(a.getSalariu()))
                .forEach(System.out::println);
        System.out.println("\n5.Nume angajati cu majuscula:\n".toUpperCase());
        List<String> nume = angajatList
                .stream()
                .map((a) -> a.getNume().toUpperCase())
                .collect(Collectors.toList());
        nume.forEach(System.out::println);
        System.out.println("\n6.Salarii mai mici decat 3000 RON:\n".toUpperCase());
        angajatList
                .stream()
                .map(Angajat::getSalariu)
                .filter((s) -> s < 3000)
                .forEach(System.out::println);
//        System.out.println("\n7.Afisare date prim angajat:\n");
//        angajatList
//                .stream()
//                .findFirst()
//                .stream()
//                .map(Angajat::getSalariu)
//                .min(Float::compareTo)
//                .ifPresentOrElse((s)-> System.out.println(s),()-> System.out.println("Nu este valoare."));
        System.out.println("\n8.Statisici salariu:\n".toUpperCase());
        DoubleSummaryStatistics statistics = angajatList
                .stream()
                .map(Angajat::getSalariu)
                .collect(Collectors.summarizingDouble(e -> e));
        System.out.println("Salariu mediu: " + statistics.getAverage()
                + "\nSalariu minim: " + statistics.getMin()
                + "\nSalariu maxim: " + statistics.getMax());
        System.out.println("\n9.Ion din firma:\n".toUpperCase());
        angajatList
                .stream()
                .map(Angajat::getNume)
                .filter((s)->s.equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse((i)-> System.out.println("Firma contine cel putin un Ion"),()-> System.out.println("Firma nu are niciun Ion angajat"));
        System.out.print("\n10.Numarul de pers angajate in vara anului precedent: ".toUpperCase());
        int nr = (int)angajatList
                .stream()
                .map(Angajat::getData_angajarii)
                .filter((d)->d.getYear() == an)
                .filter((d)->d.getMonthValue() == 6 || d.getMonthValue() == 7 || d.getMonthValue() == 8 )
                .count();
        System.out.println(nr);
    }
}