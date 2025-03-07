package br.ufpb.dcx.angelo.vendasRoupas;

public class ProdutoNaoExisteException extends Exception {
    ProdutoNaoExisteException (String mgs){
        super (mgs);
    }
}
