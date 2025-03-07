package br.ufpb.dcx.angelo.vendasRoupas;

public class ProdutoJaExisteException extends Exception {
    ProdutoJaExisteException(String msg){
        super (msg);
    }
}
