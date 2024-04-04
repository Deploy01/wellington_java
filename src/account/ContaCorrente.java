package account;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;

public class ContaCorrente extends Conta{
	private double limiteEspecial;
	public ContaCorrente(double saldo, double limiteEspecial) {
		super(saldo);
		this.limiteEspecial = limiteEspecial;
	}

	@Override
	public void sacar(double valor) throws ExceptionLimite, ExceptionNegativoZero, ExceptionSaque {
		double limite = this.limiteEspecial;
		if (getSaldo() - valor < limiteEspecial) {
			throw new ExceptionLimite("Saldo ultrapassou o valor do limite especial");
		}
		if (valor <= 0) {
			throw new ExceptionNegativoZero();
		}
		super.sacar(valor);
	}
	@Override
	public String toString() {
		return "Saldo: " + getSaldo() + " Limite especial: " + this.limiteEspecial;
	}
}
