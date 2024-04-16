package menu;

public abstract class Menu {
    private int opcao;
    private String mensagemMenu;

    public Menu(int opcao, String mensagemMenu) {
        this.opcao = opcao;
        this.mensagemMenu = mensagemMenu;
    }

    public void executar(){
        executarMenu();
    }

    protected abstract void executarMenu();

    protected abstract void avaliarOpcaoEscolhida();


    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

	public String getMensagemMenu() {
		return mensagemMenu;
	}

	public void setMensagemMenu(String mensagemMenu) {
		this.mensagemMenu = mensagemMenu;
	}
    
}
