package account;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaldo;


import javax.swing.*;

public abstract class Conta {
	private double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor){

		try {
			if (valor <= 0) {
				throw new ExceptionNegativoZero("O valor não pode ser menor ou igual a zero");
			}

			this.saldo += valor;
		} catch (ExceptionNegativoZero e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		} catch(NumberFormatException e) {
			System.out.println("Letras ou caracteres especiais não são permitidos. Digite um número");
		}
		
		
	}
	
	public void sacar(double valor){ // não é aqui que faremos o tratamento para contaCC

		try {
			if (valor <= 0) {
				throw new ExceptionNegativoZero("O valor não pode ser menor ou igual a zero");
			} 

			this.saldo -= valor;
		} catch (ExceptionNegativoZero e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
		}

		


	}
	//XXX // passei mais tempo aqui do que no código todo. 
	public void atualizarSaldo(double valorSaque){ // não achei outro jeito de fazer isso sem parametro
		if (this.saldo < 0) {
	        double valorExcedente = Math.min(Math.abs(this.saldo), valorSaque) * 0.08; // NINGUEM MEXE MAIS !!!!!!!!!!!!!!!!!!
	        this.saldo -= valorExcedente; // ????? // funcionou.
	    }

		
	}
	
	public void setSaldo(double saldo) {
		try {
			this.saldo = saldo;
			if (this.saldo < 0) {
				throw new ExceptionSaldo("Você está negativado!");
			}
			
		} catch (ExceptionSaldo e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		
	}
	public double getSaldo() {
		return saldo;
		
	}
}
