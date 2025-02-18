package br.ufpb.dcx.angelo.lojaRoupa;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeRoupa {
    private String arquivoRoupas;

    public GravadorDeRoupa(){
        this.arquivoRoupas = "roupas.dat";
    }
    public Collection<Roupa> recuperaRoupa() throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoRoupas))){
            Collection<Roupa> roupasAchadas = (ArrayList<Roupa>) in.readObject();
            return roupasAchadas;
        }catch (ClassNotFoundException | ClassCastException e){
            throw new IOException(e);
        }

    }

    public void gravaRoupas(Collection<Roupa> roupas) throws IOException {
        ArrayList<Roupa> roupasArrayList = new ArrayList<>();
        roupasArrayList.addAll(roupas);
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoRoupas))){
            out.writeObject(roupasArrayList);
        }
//
    }
//
//        out.writeObject(roupasArrayList);
//
  }

// ObjectOutputStream out = null; //new ObjectOutputStream(new FileOutputStream(arquivoRoupas));
//        try{
//            out = new ObjectOutputStream (new FileOutputStream(arquivoRoupas));
//            out.writeObject(roupasArrayList);
//        }finally{

