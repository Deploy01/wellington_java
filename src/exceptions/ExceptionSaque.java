package exceptions;

public class ExceptionSaque extends Exception{
	public String toString() {
		return "O valor de saque n�o pode ser menor maior que o saldo. Caloteiro!";
	}
}