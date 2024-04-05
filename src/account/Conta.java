package account;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;

import javax.swing.*;

public class Conta {
	private double saldo;

	public Conta(double saldo) {
		super();
		this.saldo = saldo;
	}

	public void depositar(double valor) throws ExceptionNegativoZero {

		if (valor <= 0) {
			throw new ExceptionNegativoZero();
		}
		
		this.saldo += valor;
	}
	
	public void sacar(double valor) throws ExceptionSaque, ExceptionNegativoZero, ExceptionLimite {
		
		if(valor > this.saldo) {
			throw new ExceptionSaque();
		} else if (valor <= 0) {
			throw new ExceptionNegativoZero();
		} else {
			this.saldo -= valor;
		}
		
	}
	
	public void atualizarSaldo() {
		if(saldo < 0) {
			double calculo = Math.abs(saldo) * 0.08;
			saldo += calculo;
		}
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getSaldo() {
		return saldo;
	}



}
