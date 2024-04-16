package account;

public class ContaPoupanca extends Conta{
	private double reajusteMensal;

	public ContaPoupanca(double saldo, double reajusteMensal) {
		super(saldo);
		this.reajusteMensal = reajusteMensal;
	}

	public void atualizarSaldo(double reajuste){ // fiquei confuso sobre como funciona isso. Mas eu acho que é assim.
		depositar(getSaldo() * reajuste);
		this.reajusteMensal = reajuste;

	}
	@Override
	public String toString() {
		return "Saldo: " + getSaldo() + "\nReajuste mensal: " + reajusteMensal;
	}


}
