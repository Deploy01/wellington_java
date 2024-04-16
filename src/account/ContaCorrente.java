package account;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{
	private double limiteEspecial;
	public ContaCorrente(double saldo, double limiteEspecial) {
		super(saldo);
		this.limiteEspecial = limiteEspecial;
	}

	@Override
	public void sacar(double valor){ // é aqui que faremos o tratamento
		
		try {
			double novoSaldo = getSaldo() - valor;

			if (valor <= 0) {
				throw new ExceptionNegativoZero("O valor não pode ser menor ou igual a zero");
			} 

	        if (novoSaldo < -getLimiteEspecial()) {
	            throw new ExceptionLimite("Saldo insuficiente. Limite especial excedido");
	        }
	        setSaldo(novoSaldo);
	        atualizarSaldo(valor); // não mexe!!!!!
		} catch (ExceptionNegativoZero e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (ExceptionLimite e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		
	}
	@Override
	public String toString() {
		return "Saldo: " + getSaldo() + "\nLimite especial: " + limiteEspecial;
	}

	public double getLimiteEspecial() {
		return limiteEspecial;
	}
}
