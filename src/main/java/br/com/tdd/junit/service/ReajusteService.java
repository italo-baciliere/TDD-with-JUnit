package br.com.tdd.junit.service;

import java.math.BigDecimal;

import br.com.tdd.junit.modelo.Desempenho;
import br.com.tdd.junit.modelo.Funcionario;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }

    
}