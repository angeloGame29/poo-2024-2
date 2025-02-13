import br.ufpb.dcx.joão.professores.SistemaGerenciaProfsMap;

import java.util.LinkedList;
import java.util.List;

public class SistemaGerenciaProfsMapTest {

    @Test
    public void testaCadastriProf() {
        SistemaGerenciaProfsMap sistema = new SistemaGerenciaProfsMap();
        try {
            sistema.cadastraProfessor(111, "josé");
            List<String> disciplinasDeJose = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertTrue (disciplinasDeJose.size()==0);
            assertEquals(0, disciplinasDeJose.size());
            List<Horario> horariosDisciplina = new LinkedList<>();
            Horario horarioAula1 = new Horario(diaDaSemana, TERCA, 10,12);
            horariosDisciplina.add(horarioAula1);
            Horario horarioAula2 = new Horario(diaDaSemana, TERCA, 13,15);
            horariosDisciplina.add(horarioAula2);
            sistema.cadastraDisciplina("poo", 22,111,horariosDisciplina);
            List<String> disciplinasDejoseDepois = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals(1,disciplinasDejoseDepois.size());
            assertTrue(disciplinasDejoseDepois.get())

        }catch (ProfessorJaExisteExcepion | DisciplinaJaExisteExcepiton e){
            e.printStacktrace();
            fail("Exceção não esperada");
        }
    }
}
