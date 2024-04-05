package account;

import exceptions.ExceptionNegativoZero;

import javax.swing.*;

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
		this.reajusteMensal = reajuste;
		double novoSaldo = getSaldo() + (getSaldo() * (reajuste/100));
		setSaldo(novoSaldo);
	}
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "Saldo: " + getSaldo() + " Reajuste mensal: " + reajusteMensal);
		return "Saldo: " + getSaldo() + " Reajuste mensal: " + reajusteMensal;
	}


}
