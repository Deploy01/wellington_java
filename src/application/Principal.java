package application;

import javax.swing.JOptionPane;

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

			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ExceptionSaque e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ExceptionLimite e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}