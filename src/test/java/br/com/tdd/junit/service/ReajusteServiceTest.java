package br.com.tdd.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tdd.junit.modelo.Desempenho;
import br.com.tdd.junit.modelo.Funcionario;
    
public class ReajusteServiceTest {
    
    // Abordagem onde eu passo um parametro e esse objeto recebe uma alteração

    private ReajusteService service;
    private Funcionario funcionario;

   @BeforeEach   
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }    

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);                
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForABom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForAOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
