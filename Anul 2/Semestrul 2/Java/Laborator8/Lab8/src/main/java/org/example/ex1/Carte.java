package org.example.ex1;

public record Carte(String titlul,String autorul,Integer anul) {
    @Override
    public String toString() {
        return titlul + ", " + autorul + ", " + anul;
    }
}
