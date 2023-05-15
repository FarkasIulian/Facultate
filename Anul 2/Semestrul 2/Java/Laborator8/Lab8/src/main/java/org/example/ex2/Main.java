package org.example.ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void scriere(Set<InstrumentMuzical> colectie) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/instrumente.json");
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(file, colectie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/instrumente.json");
            Set<InstrumentMuzical> colectie = mapper.readValue(file, new TypeReference<Set<InstrumentMuzical>>() {
            });
            return colectie;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Set<InstrumentMuzical> colectie = new HashSet<>();
        colectie.add(new Chitara("LIDL", 4500, TipChitara.CLASICA, 5));
        colectie.add(new Chitara("Kaufland", 3000, TipChitara.ACUSTICA, 7));
        colectie.add(new Chitara("Jumbo", 4001, TipChitara.ELECTRICA, 6));
        colectie.add(new SetTobe("Exemplu1", 5451.55, TipTobe.ACUSTICE, 5, 4));
        colectie.add(new SetTobe("Exemplu2", 1234.56, TipTobe.ELECTRICE, 3, 6));
        colectie.add(new SetTobe("Exemplu3", 2000, TipTobe.ACUSTICE, 8, 8));
        scriere(colectie);
        Set<InstrumentMuzical> colectieJSON = citire();
        System.out.println("Tipul setului implementat: " + colectieJSON.getClass());
        colectieJSON.forEach(System.out::println);
        System.out.println();
        int size = colectieJSON.size();
        colectieJSON.add(new Chitara("LIDL", 4500, TipChitara.CLASICA, 5)); // duplicata
        if (colectieJSON.size() == size + 1)
            System.out.println("Duplicata adauga");
        else {
            System.out.println("Override-ul la equals si hash nu permite duplicate in set!");
        }
        System.out.println();
        colectieJSON.forEach(System.out::println);
        System.out.println();
        colectieJSON.removeIf((a) -> a.getPret() > 3000);
        colectieJSON.forEach(System.out::println);
        System.out.println("\nChitarile:\n");
        colectieJSON.stream().filter(i -> i instanceof Chitara).forEach(System.out::println);
        System.out.println("\nTobele:\n");
        colectieJSON.stream().filter(i -> i.getClass().equals(SetTobe.class)).forEach(System.out::println);
        var max = colectieJSON.stream()
                .filter(i -> i instanceof Chitara)
                .map(c -> (((Chitara) c).getNr_corzi()))
                .max(Integer::compareTo);
        System.out.println("\nChitara cu nr corzi maxim!\n");
        max.ifPresent((x) -> colectieJSON.stream()
                .filter(c -> c instanceof Chitara && ((Chitara) c).getNr_corzi().equals(max.get()))
                .forEach(System.out::println));
        System.out.println("\nTobele acustice ordonate!\n");
        colectieJSON.stream()
                .filter(t -> t instanceof SetTobe)
                .filter(t -> ((SetTobe) t).getTip_tobe().equals(TipTobe.ACUSTICE))
                .sorted((a, b) -> ((SetTobe)a).getNr_tobe().compareTo(((SetTobe)b).getNr_tobe()))
                .forEach(System.out::println);

    }
}
