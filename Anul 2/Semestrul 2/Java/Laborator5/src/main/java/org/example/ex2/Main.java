package org.example.ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exemplul1.Persoana;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void scriere(List<PerecheNumere> lista){
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/numere.json");
            mapper.writeValue(file,lista);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<PerecheNumere> citire(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/numere.json");
            List<PerecheNumere> lista = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        List<PerecheNumere> numere = citire();
        System.out.println(numere);
        for(PerecheNumere p: numere)
            System.out.println(p.nrpare());
    }
}
