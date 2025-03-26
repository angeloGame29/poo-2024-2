package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

public class TarefaNaoExisteException extends Exception {
    public TarefaNaoExisteException (String msg){
        super (msg);
    }
}
