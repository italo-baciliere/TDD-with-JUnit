package br.com.tdd.junit.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.tdd.junit.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {			
			throw new IllegalArgumentException("Funcionário com salário maior de 10.000 não possui direito a bonus!");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}
