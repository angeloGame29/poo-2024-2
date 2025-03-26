package br.ufpb.dcx.angelo.gerenciadorDeTarefas;

public class TarefaJaExisteException extends Exception {
    public TarefaJaExisteException (String msg){
        super (msg);
    }
}
