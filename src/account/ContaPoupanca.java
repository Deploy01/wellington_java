package account;

import exceptions.ExceptionNegativoZero;

import javax.swing.*;

public class ContaPoupanca extends Conta{
	private double reajusteMensal;

	public ContaPoupanca(double saldo, double reajusteMensal) {
		super(saldo);
		this.reajusteMensal = reajusteMensal;
	}

	public void atualizarSaldo(double reajuste) throws ExceptionNegativoZero { // fiquei confuso sobre como funciona isso. Mas eu acho que é assim.
		if (reajuste <= 0) {
			throw new ExceptionNegativoZero();
		}
		setSaldo(getSaldo() + getSaldo() * reajuste); // teoricamente, tá funcionando. Na pratica... Eu não sei. Vejam se eu errei pfv
		this.reajusteMensal = reajuste;
//ep2 feio, mas funciona
	}
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "Saldo: " + getSaldo() + " Reajuste mensal: " + reajusteMensal);
		return "Saldo: " + getSaldo() + " Reajuste mensal: " + reajusteMensal;
	}


}
