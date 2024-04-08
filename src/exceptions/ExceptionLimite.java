package exceptions;

public class ExceptionLimite extends Exception{
    public ExceptionLimite() {
        super("Saldo ultrapassou o valor do limite especial");
    }
}
