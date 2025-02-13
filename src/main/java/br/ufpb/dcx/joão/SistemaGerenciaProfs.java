package br.ufpb.dcx.joão;

public interface SistemaGerenciaProfs {
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf);

    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf);

    public void cadastraProfessor(int matriculaProf, String nome)
            throws ProfessorJaExisteException;

    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina,
                                   int matriculaProfessor, List<Horario> horarios) throws
            DisciplinaJaExisteException;

    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws
            DisciplinaInexistenteException;

    public Professor pesquisaProfessor(int matriculaProfessor) throws
            ProfessorInexistenteException;

}
