package org.example.ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzical {
    private String producator;
    private double pret;

    public InstrumentMuzical() {}

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public double getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return producator + ", " + pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentMuzical instr = (InstrumentMuzical) o;
        return producator.equals(instr.producator) && (pret == instr.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator,pret);
    }
}
