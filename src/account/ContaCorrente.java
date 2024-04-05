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

	public void sacar(double valor) throws ExceptionLimite, ExceptionNegativoZero, ExceptionSaque {
		/* if (getSaldo() - valor > limiteEspecial) {
			throw new ExceptionLimite("Saldo ultrapassou o valor do limite especial");
		} */
		if (valor <= 0) {
			throw new ExceptionNegativoZero();
		}
		super.sacar(valor);
	}
	@Override // isso é feio, mas eu só quero acabar
	public String toString() {
		JOptionPane.showMessageDialog(null, "Saldo: " + getSaldo() + " Limite especial: " + limiteEspecial);
		return "Saldo: " + getSaldo() + " Limite especial: " + limiteEspecial;
	}
}
