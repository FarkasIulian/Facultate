package org.example.ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(Map<Integer, Carte> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer, Carte>>() {
            });
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisare(Map<Integer, Carte> colectie) {
//        var entryset = colectie.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
//                .collect(Collectors.toList()); // daca vrem sa sortam cheile
        var entryset = colectie.entrySet();
        var it = entryset.iterator();
        while (it.hasNext()) {
            var m = it.next();
            Integer key = m.getKey();
            Carte c = m.getValue();
            System.out.println("Key: " + key + "\nValue: " + c);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Map<Integer, Carte> colectie = new HashMap<>();
        colectie = citire();
        System.out.println("\n1.AFISARE ORIGINAL.\n");
        afisare(colectie);
        colectie.remove(3); // stergere dupa cheie
        System.out.println("\n2.AFISARE DUPA STERGERE.\n");
        afisare(colectie);
        colectie.putIfAbsent(3, new Carte("Povesti din copilarie", "Ion Creanga", 1892));
        System.out.println("\n3.AFISARE DUPA ADAUGARE.\n");
        afisare(colectie);
        scriere(colectie);
        Set<Carte> colectieSet;
        System.out.println("\n3.AFISARE SET NEORDONAT.\n");
        colectieSet = colectie.values().stream().filter((Carte c) -> c.autorul().equals("Yuval Noah Harari")).collect(Collectors.toSet());
        colectieSet.forEach(System.out::println);
        System.out.println("\n3.AFISARE SET ORDONAT DUPA TITLU.\n");
        colectieSet.stream().sorted((c1, c2) -> c1.titlul().compareToIgnoreCase(c2.titlul())).forEach(System.out::println);
        System.out.println("\n4.AFISARE DATE CEA MAI VECHE CARTE.\n");
        var min = colectieSet.stream()
                .map(Carte::anul)
                .min(Integer::compareTo);
        min.ifPresentOrElse((x) ->
                        colectieSet.stream().filter(c -> c.anul().equals(min.get())).forEach(System.out::println),
                () -> System.out.println("Eroare"));
    }
}