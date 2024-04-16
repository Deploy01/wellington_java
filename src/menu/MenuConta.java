
package menu;

import account.ContaCorrente;
import account.ContaPoupanca;
import javax.swing.JOptionPane;

public class MenuConta extends Menu {

    private ContaCorrente contaCC;
    private ContaPoupanca contaCP;

    public MenuConta() {
        super(0, "Escolha uma Opção");
        contaCC = new ContaCorrente(500, 1000);

        contaCP = new ContaPoupanca(5000, 0.01); // 0.01 = 1% // 1 = 100%
    }

    protected void executarMenu(){
        String[] options = {"1 - Conta Corrente", "2 - Conta Poupança", "0 - Sair"};

         int x = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção",
            "Titulo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options, options[0]);

        setOpcao(x);
        avaliarOpcaoEscolhida();
    }

    protected void avaliarOpcaoEscolhida(){
        switch (getOpcao()) {
            case 0: {

                operarContaCC();
                break;
            }
            case 1: {

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

    private void operarContaCC(){
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "0 - Voltar"};
        
        int opcaoCC = JOptionPane.showOptionDialog(
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
                JOptionPane.showMessageDialog(null, contaCC.toString());
                operarContaCC();
                break;
            }
            case 1: {
	                String deposito = JOptionPane.showInputDialog("Valor de depósito: ");
	                
	                try {

//tratamento
	                	contaCC.depositar(Double.parseDouble(deposito));
		                operarContaCC(); 

	                } catch (NumberFormatException e ) {
	            		JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
	            		operarContaCC();
	                } catch (NullPointerException e) {
	            		operarContaCC();
	                }

                break;
            }
            case 2: {
//socorro

            	try {
            		String saque = JOptionPane.showInputDialog("Valor de saque: ");

            		contaCC.sacar(Double.parseDouble(saque));
                    operarContaCC(); // volta pra tela anteiror

	            	} catch (NumberFormatException e ) {
	            		JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
	            		operarContaCC();
	            	} catch (NullPointerException e) {
	            		operarContaCC();
	                }

                break;
            }
            case 3: {
                executarMenu();
                break;

            }
            default: {
                JOptionPane.showMessageDialog(null,"Opção inválida");
                break;
            }
        }
    }

    private void operarContaCP(){
        String[] options = {"1 - Consultar saldo", "2 - Depósito", "3 - Sacar", "4 - Atualizar saldo", "0 - Voltar"};
        
        
        int opcaoCP = JOptionPane.showOptionDialog(
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
                JOptionPane.showMessageDialog(null, contaCP.toString());
                operarContaCP();
                break;
            }
            case 1: {
                String deposito = JOptionPane.showInputDialog("Valor de depósito: ");
                
                
                try {
                	contaCP.depositar(Double.parseDouble(deposito));
                    operarContaCP();
            	} catch (NumberFormatException e ) { 
            		JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
            		operarContaCP();
            	} catch (NullPointerException e) {
                	operarContaCP();
                }

                break;
            }
            case 2: {
                String saque = JOptionPane.showInputDialog("Valor de saque");

                
                try {
                	contaCP.sacar(Double.parseDouble(saque));
                    operarContaCP();

                } catch (NumberFormatException e ) {
            		JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
            		operarContaCP();
                } catch (NullPointerException e) {
                	operarContaCP();
                }
                
                break;
            }
            case 3: {
                String reajuste = JOptionPane.showInputDialog("Valor de reajuste: ");

                try {
	            	contaCP.atualizarSaldo(Double.parseDouble(reajuste));
	                operarContaCP();

                } catch (NumberFormatException e ) {
            		JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número");
            		operarContaCP();
                }  catch (NullPointerException e) {
                	operarContaCP();
                }
                
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
