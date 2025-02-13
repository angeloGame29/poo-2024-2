package br.ufpb.dcx.joão;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaGerenciaProfsMap implements SistemaGerenciaProfs {
    private Map<Integer, Professor> professores = new HashMap<>();
    private Map<Integer, Disciplina> disciplinas = new HashMap<>();


    @Override
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) {
        List <Horario> horarios = new LinkedList<Horario>();
        for (Disciplina d: this.disciplinas.values()){
            if (d.getMatriculaProfessor() == matriculaProf){
                horarios.addAll(p.getHorarios());
            }
        }
        return horarios;
    }

    @Override
    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf) {
        List <String> nomesDisciplinas =  new LinkedList<>();
        for (Disciplina d: this.disciplinas.values()){
           if (d.getMatriculaProfessor() == matriculaProf){
               nomesDisciplinas.addAll(d.getNome());
           }
        }
        return nomesDisciplinas;
    }

    @Override
    public void cadastraProfessor(int matriculaProf, String nome) throws ProfessorJaExisteException {

    }

    @Override
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina, int matriculaProfessor, List<Horario> horarios) throws DisciplinaJaExisteException {
        if (this.disciplinas.containsKey(codigoDisciplina)){
            throw new DisciplinaJaExisteException("Já existe a disciplina com código"+ codigoDisciplina);
        }else{
            this.disciplinas.put(codigoDisciplina, new Disciplina(nomeDisciplina, codigoDisciplina, matriculaProfessor, horarios));
        }
    }

    @Override
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws DisciplinaInexistenteException {
        return null;
    }

    @Override
    public Professor pesquisaProfessor(int matriculaProfessor) throws ProfessorInexistenteException {
        Professor p = this.professores.get(matriculaProf);
        if (p == null)
            throw new ProfessorInexistenteException ("Não existe professor com essa  matrícula:"+ matriculaProf);
        else
            return p;      }
}
