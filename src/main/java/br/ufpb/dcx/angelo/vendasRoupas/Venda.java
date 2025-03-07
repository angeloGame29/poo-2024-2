package br.ufpb.dcx.angelo.vendasRoupas;

import java.util.Objects;

public class Venda {
    private String codigoProduto;
    private double valorProduto;
    private Mes mes;
    private int ano;

    public Venda (String codigoProduto, double valorProduto, Mes mes, int ano){
        this.codigoProduto = codigoProduto;
        this.valorProduto = valorProduto;
        this.mes = mes;
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    @Override
    public String toString() {
        return "Detalhes da venda:\n"+
                "codigoProduto: " + codigoProduto +"\n"+
                "valorProduto: " + valorProduto +"\n"+
                "mes: " + mes +"\n"+
                "ano: " + ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(codigoProduto, venda.codigoProduto) && mes == venda.mes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProduto, mes);
    }
}
