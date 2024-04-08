package account;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;


import javax.swing.*;

public class ContaCorrente extends Conta{
	private double limiteEspecial;
	public ContaCorrente(double saldo, double limiteEspecial) {
		super(saldo);
		this.limiteEspecial = limiteEspecial;
	}

	@Override
	public void sacar(double valor) throws ExceptionLimite, ExceptionNegativoZero, ExceptionSaque {
		
		setSaldo(getSaldo() - valor);
		if (valor <= 0) {
			throw new ExceptionNegativoZero();
		}
	}
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "Saldo: " + getSaldo() + " Limite especial: " + limiteEspecial);
		return "Saldo: " + getSaldo() + " Limite especial: " + limiteEspecial;
		
	}

	public double getLimiteEspecial() {
		return limiteEspecial;
	}
}
