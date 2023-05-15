package org.example.ex2;

enum TipChitara{
    ELECTRICA,
    ACUSTICA,
    CLASICA
}
public class Chitara extends InstrumentMuzical{
    private TipChitara tip_chitara;
    private Integer nr_corzi;

    public Chitara() {}

    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    public TipChitara getTip_chitara() {
        return tip_chitara;
    }

    public Integer getNr_corzi() {
        return nr_corzi;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tip_chitara.toString() + ", " + nr_corzi;
    }
}
