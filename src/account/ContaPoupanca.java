package account;

import exceptions.ExceptionNegativoZero;

public class ContaPoupanca extends Conta{


	private double reajusteMensal;

	public ContaPoupanca(double saldo, double reajusteMensal) {
		super(saldo);
		this.reajusteMensal = reajusteMensal;
	}

	public void atualizarSaldo(double reajuste) throws ExceptionNegativoZero {
		if (reajuste <= 0) {
			throw new ExceptionNegativoZero();
		}
		double novoSaldo = getSaldo() + (getSaldo() * (reajuste/100));
		setSaldo(novoSaldo);
	}
	@Override
	public String toString() {
		return "Conta Poupança: " + "Saldo: " + getSaldo() + " Reajuste mensal: " + reajusteMensal;
	}
}
