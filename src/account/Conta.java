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
	//XXX // passei mais tempo aqui do que no código todo. 
	public void atualizarSaldo(double valorSaque) throws ExceptionNegativoZero { // https://prnt.sc/LdMBu3J0I7FK // não achei outro jeito de fazer isso sem parametro
		if (this.saldo < 0) {
	        double valorExcedente = Math.min(Math.abs(this.saldo), valorSaque) * 0.08; // NINGUEM MEXE MAIS !!!!!!!!!!!!!!!!!!
	        this.saldo -= valorExcedente; // por que isso funcionou????? // algum outro lugar está errado. deveria ser -40. // funcionou.
	    }
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
		
		
	}
	public double getSaldo() {
		return saldo;
	}
}
