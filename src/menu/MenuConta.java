package menu;

import account.ContaCorrente;
import account.ContaPoupanca;
import exceptions.*;

import javax.swing.*;

public class MenuConta extends Menu {

    private ContaCorrente contaCC;
    private ContaPoupanca contaCP;

    public MenuConta() {
        super(0, "Escolha uma Opção");
        contaCC = new ContaCorrente(500, 1000);

        contaCP = new ContaPoupanca(5000, 0.01);
        this.setOpcao(0);
    }

    protected void executarMenu() {
        String[] options = {"1 - Conta Corrente", "2 - Conta Poupança", "0 - Sair"};
        int x;

        do {
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

        } while (x != 3);
        System.out.println("Saindo");



    }

    protected void avaliarOpcaoEscolhida() {
        try {
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
        } catch (Exception e) {
            System.out.println("maluco bugou o código");
        }
    }

    private void operarContaCC() {
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "4 - Atualizar saldo", "0 - Voltar"};
        int y;

        do {
            y = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção",
                    "Titulo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options, options[0]);

            setOpcao(y);
            avaliarOpcaoEscolhida();

        } while (y != 3);

        executarMenu();
        try {
            switch (getOpcao()) {
                case 0: {
                    System.out.println("1");
                    contaCC.toString();
                    break;
                }
                case 1: {
                    System.out.println("2");

                    double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito"));
                    if (deposito <= 0) {
                        throw new ExceptionNegativoZero();
                    }
                    contaCC.depositar(deposito);
                    break;
                }
                case 2: {
                    System.out.println("3");

                    double saque = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque"));
                    if (saque <= 0) {
                        throw new ExceptionSaque();
                    }
                    contaCC.sacar(saque);
                    break;
                }
                case 3: {
                    System.out.println("4");
                    contaCC.atualizarSaldo();
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
        } catch (Exception e) {
            System.out.println("maluco bugou o código");
        }

        System.out.println("Saindo");
    }

    private void operarContaCP() {
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "4 - Atualizar saldo", "0 - Voltar"};
        int y;

        do {
            y = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção",
                    "Titulo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options, options[0]);

            avaliarOpcaoEscolhida();
            setOpcao(y);
        } while (y != 3);

        executarMenu();
        try {
            switch (getOpcao()) {
                case 0: {
                    System.out.println("1");
                    contaCP.toString();
                    break;
                }
                case 1: {
                    System.out.println("2");

                    double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                    if (deposito <= 0) {
                        throw new ExceptionNegativoZero();
                    }
                    contaCP.depositar(deposito);
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
                    break;
                }
                case 3: {
                    System.out.println("4");
                    double reajuste = Double.parseDouble(JOptionPane.showInputDialog("Valor de reajuste: "));

                    contaCP.atualizarSaldo(reajuste);
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
        } catch (Exception e) {
            System.out.println("maluco bugou o código");
        }

        System.out.println("Saindo");
    }




}
