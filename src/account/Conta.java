package account;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;
import menu.MenuConta;

import javax.swing.*;

public abstract class Conta {
	private double saldo;

	public Conta(double saldo) {
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
			saldo -= valor;
		}

	}
	public void atualizarSaldo() { // https://prnt.sc/LdMBu3J0I7FK
		if (this.saldo < 0) {
			double valorExcedente = Math.abs(this.saldo) * 0.08;
			this.saldo -= valorExcedente;
		}
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
		atualizarSaldo(); // funcionou? 
		

	}
	public double getSaldo() {
		return saldo;
	}
}
