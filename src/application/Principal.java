package application;

import menu.MenuConta;

public class Principal {

	public static void main(String[] args) {
		MenuConta menu = new MenuConta();
		try {
			menu.executar();
		} catch (Exception e) {
			System.out.println("Maluco bugou o código aqui");
		}
	}

}
