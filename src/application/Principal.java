package application;

import exceptions.ExceptionLimite;
import exceptions.ExceptionNegativoZero;
import exceptions.ExceptionSaque;
import menu.MenuConta;

public class Principal {

	public static void main(String[] args) {
		MenuConta menu = new MenuConta();

			try {
				menu.executar();
			} catch (ExceptionNegativoZero e) {

				e.printStackTrace();
			} catch (ExceptionSaque e) {

				e.printStackTrace();
			} catch (ExceptionLimite e) {

				e.printStackTrace();
			}

	}

}
