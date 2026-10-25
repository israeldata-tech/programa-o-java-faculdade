package aula2;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class PersonagemTreinoMain {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite o nome do personagem:");
        
        PersoTreino pe = new PersoTreino(nome);

        int opcao = JOptionPane.showConfirmDialog(null, 
            "Deseja enviar " + nome + " para uma missão?", 
            "Confirmação", 
            JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            pe.iniciarMissao();
        }
        pe.exibir();
    }
}

class PersoTreino {
    private String nome;
    private int nivel;
    private boolean emMissao;

    public PersoTreino(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.emMissao = false;
    }
    public void iniciarMissao() {
        this.emMissao = true;
        this.nivel += 1;
        JOptionPane.showMessageDialog(null, this.nome + " entrou em uma missão!");
    }
    public void exibir() {
        String status = this.emMissao ? "Sim" : "Não";
        JOptionPane.showMessageDialog(null, 
            "Nome: " + this.nome + 
            "\nNível: " + this.nivel + 
            "\nEm missão: " + status);
    }
}