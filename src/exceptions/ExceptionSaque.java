package exceptions;

public class ExceptionSaque extends Exception{
	public String toString() {
		return "O valor de saque não pode ser maior que o saldo. Caloteiro!";
	}
}
