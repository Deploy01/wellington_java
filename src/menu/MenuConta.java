package menu;

import account.ContaCorrente;
import account.ContaPoupanca;
import account.Conta;
import exceptions.*;

import javax.swing.*;

public class MenuConta extends Menu {

    private ContaCorrente contaCC;
    private ContaPoupanca contaCP;

    public MenuConta() {
        super(0, "Escolha uma Opção");
        contaCC = new ContaCorrente(500, 1000);

        contaCP = new ContaPoupanca(5000, 0.01); // 0.01 = 1% // 1 = 100%
    }

    protected void executarMenu() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite {
        String[] options = {"1 - Conta Corrente", "2 - Conta Poupança", "0 - Sair"};
        int x;

        x = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção",
            "Titulo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options, options[0]);

        setOpcao(x);
        avaliarOpcaoEscolhida();

        System.out.println("Saindo");

    }

    protected void avaliarOpcaoEscolhida() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite {
        switch (getOpcao()) {
            case 0: {
                System.out.println("1");

                operarContaCC();
                break;
            }
            case 1: {
                System.out.println("2");

                operarContaCP();
                break;
            }
            case 2: {
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }

    private void operarContaCC() throws ExceptionSaque, ExceptionNegativoZero, ExceptionLimite {
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "0 - Voltar"};
        int opcaoCC;

        opcaoCC = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção",
            "Titulo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options, options[0]);

        setOpcao(opcaoCC);

        switch (getOpcao()) {
            case 0: {
                System.out.println("1 - teste");
                contaCC.toString();
                operarContaCC();
                break;
            }
            case 1: {
                System.out.println("2");
                double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                if (deposito <= 0) {
                    throw new ExceptionNegativoZero();
                }
                contaCC.depositar(deposito);

                operarContaCC();
                break;
            }
            case 2: {
//socorro
            	double saque = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque: "));

                if (saque <= 0) {
                    throw new ExceptionNegativoZero();
                }
                if (contaCC.getSaldo() < 0) {
                	throw new ExceptionNegativoZero();
                }

                if (contaCC.getSaldo() < contaCC.getLimiteEspecial() - (contaCC.getLimiteEspecial() * 2)) {
                	throw new ExceptionLimite();
                } else {
                	contaCC.sacar(saque);
                	// feio, mas funciona. ou n�o;
                    if (contaCC.getSaldo() < contaCC.getLimiteEspecial() - (contaCC.getLimiteEspecial() * 2)) {
                    	contaCC.setSaldo(-1000); 
                    	System.out.println("segundo THROW" + contaCC.getSaldo());
                    	throw new ExceptionLimite();
                    }
                    operarContaCC();

                    System.out.println("segundo " + contaCC.getSaldo());
                    break;
                }
            }
//mds kkkkkkkkkkk
            case 3: {
                executarMenu();
                break;

            }
            default: {
                JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }

        System.out.println("Saindo");
    }

    private void operarContaCP() throws ExceptionNegativoZero, ExceptionSaque, ExceptionLimite {
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "4 - Atualizar saldo", "0 - Voltar"};
        int opcaoCP;
        opcaoCP = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção",
            "Titulo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options, options[0]);

        setOpcao(opcaoCP);

        switch (getOpcao()) {
            case 0: {
                System.out.println("1");
                contaCP.toString();
                operarContaCP();
                break;
            }
            case 1: {
                System.out.println("2");

                double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                if (deposito <= 0) {
                    throw new ExceptionNegativoZero();
                }
                contaCP.depositar(deposito);
                operarContaCP();
                break;
            }
            case 2: {
                System.out.println("3");

                double saque = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque"));
                if (saque >= contaCP.getSaldo()) {
                    throw new ExceptionSaque();
                }
                if (saque <= 0) {
                    throw new ExceptionNegativoZero();
                }
                contaCP.sacar(saque);
                operarContaCP();
                break;
            }
            case 3: {
                System.out.println("4");
                double reajuste = Double.parseDouble(JOptionPane.showInputDialog("Valor de reajuste: "));

                contaCP.atualizarSaldo(reajuste);
                operarContaCP();
                break;
            }
            case 4: {
                executarMenu();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }




}
