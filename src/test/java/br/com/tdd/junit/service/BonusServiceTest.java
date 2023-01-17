package br.com.tdd.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import br.com.tdd.junit.modelo.Funcionario;
    
public class BonusServiceTest {    
        
    BonusService bonusService = new BonusService();    

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BigDecimal bonus = bonusService.calcularBonus(
                                new Funcionario(
                                    "Italo", 
                                    LocalDate.now(),
                                    new BigDecimal("25000")
                                ));
        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService bonusSevice = new BonusService();
        BigDecimal bonus = bonusSevice.calcularBonus(
            new Funcionario(
                "Italo", 
                LocalDate.now(),
                new BigDecimal("1000")
            ));                

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentroParaSalarioDeExatamenteDezMil(){
        BonusService bonusSevice = new BonusService();
        BigDecimal bonus = bonusSevice.calcularBonus(
            new Funcionario(
                "Italo", 
                LocalDate.now(),
                new BigDecimal("10000")
            ));                

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
    