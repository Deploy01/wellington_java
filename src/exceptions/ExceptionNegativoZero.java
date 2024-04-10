package exceptions;

public class ExceptionNegativoZero extends Exception{
	public String toString() {
		return("O valor n�o pode ser menor ou igual a zero");
	}
}