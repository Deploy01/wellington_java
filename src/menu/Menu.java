package menu;

import account.ContaCorrente;
import account.ContaPoupanca;

public class Menu {
    private int opcao;
    private String mensagemMenu;

    public Menu(int opcao, String mensagemMenu) {
        this.opcao = opcao;
        this.mensagemMenu = mensagemMenu;
    }

    public void executar() {

    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
