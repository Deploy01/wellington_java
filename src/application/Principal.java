// Gabriel Lima
// Giovanna Marquez
// Pedro Roque
// Patrick Trindade


package application;

import menu.MenuConta;

public class Principal {

	public static void main(String[] args) {
		MenuConta menu = new MenuConta();

		do {
			menu.executar();
			
		} while (menu.getOpcao() != 2);
	}

}