package aula3;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class autor {
    public static void main(String[] args) {
        String n = JOptionPane.showInputDialog("digite o nome do autor: ");
        autorl a = new autorl(n);

        String t1 = JOptionPane.showInputDialog("digite o titulo do primeiro livro: ");
        double p1 = Double.parseDouble(JOptionPane.showInputDialog("digite o preço desse livro: "));
        livro l1 = new livro(t1, p1, a);

        String t2 = JOptionPane.showInputDialog("digite o titulo do segundo livro: ");
        double p2 = Double.parseDouble(JOptionPane.showInputDialog("digite o preço do segundo livro: "));
        livro l2 = new livro(t2, p2, a);

        
        l1.aplicarDesconto(40); 
        l1.aplicarDesconto(20); 

        JOptionPane.showMessageDialog(null, "Livro 1 tem autor? " + l1.temautor());
        
        
        boolean mesmo = l1.mesmoAutorQue(l2);
        JOptionPane.showMessageDialog(null, "Mesmo autor (mesmo endereço no Heap)? " + mesmo);
    }
}

class autorl {
    private String nome;

    public autorl(String n) {
        setnome(n);
    }

    public void setnome(String n) {
        this.nome = n;
    }

    public String getnome() {
        return this.nome;
    }
}

class livro {
    private String nome;
    private double p;
    private autorl autorl;

    public livro(String n, double p, autorl autorl) {
        setnome(n);
        setpre(p);
        this.autorl = autorl;
    }

    public void setnome(String n) {
        this.nome = n;
    }

    public void setpre(double p) {
        this.p = p;
    }

    public String getnome() {
        return this.nome;
    }

    public double getp() {
        return this.p;
    }

    public autorl getautorl() {
        return this.autorl;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem > 30.0) {
            JOptionPane.showMessageDialog(null, "Desconto não permitido! O limite é 30%.");
        } else {
            this.p -= this.p * (porcentagem / 100.0);
            JOptionPane.showMessageDialog(null, "Desconto aplicado! Novo preço: R$ " + this.p);
        }
    }

    public boolean temautor() {
        return this.autorl != null;
    }

    public boolean mesmoAutorQue(livro outro) {
        if (outro == null || !outro.temautor() || !this.temautor()) {
            return false;
        }
        return this.autorl == outro.getautorl();
    }
}