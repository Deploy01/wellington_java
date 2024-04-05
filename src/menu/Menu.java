package menu;

import account.ContaCorrente;
import account.ContaPoupanca;
import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;

public abstract class Menu {
    private int opcao;
    private String mensagemMenu;

    public Menu(int opcao, String mensagemMenu) {
        this.opcao = opcao;
        this.mensagemMenu = mensagemMenu;
    }

    public void executar() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite {
        executarMenu();
    }

    protected abstract void executarMenu() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite;

    protected abstract void avaliarOpcaoEscolhida() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite;


    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
