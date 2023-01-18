package br.com.tdd.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import br.com.tdd.junit.modelo.Funcionario;
    
public class BonusServiceTest {    
        
    private BonusService bonusService = new BonusService();    

    // Abordagem onde eu monitor se esta sendo retornado uma excecao
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){        
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(
                                                                            new Funcionario(
                                                                            "Italo", 
                                                                            LocalDate.now(),
                                                                            new BigDecimal("25000")
        )));

        // abordagem útil para quando você precisar pegar a mensagem da excecao
        // try {
        //     bonusService.calcularBonus(new Funcionario("Italo", LocalDate.now(), new BigDecimal("25000")));
        //     fail("Não obteve uma excecao");
        // } catch (Exception e) {/*e.getMessage()*/}
    }

    // Abordagem que retorna um valor, para saber se estou obtendo um retorno desejado
    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){        
        BigDecimal bonus = bonusService.calcularBonus(
            new Funcionario(
                "Italo", 
                LocalDate.now(),
                new BigDecimal("2500")
            ));                

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentroParaSalarioDeExatamenteDezMil(){        
        BigDecimal bonus = bonusService.calcularBonus(
            new Funcionario(
                "Italo", 
                LocalDate.now(),
                new BigDecimal("10000")
            ));                

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
    