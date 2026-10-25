package aula2;
import javax.swing.JOptionPane;
public class itemmagico {
    public static void main(String[] args) {
        String nome=JOptionPane.showInputDialog("digite o nome do item: ");
        int at=Integer.parseInt(JOptionPane.showInputDialog(null, "digite os pontos de ataque do item: "));
        double p=Double.parseDouble(JOptionPane.showInputDialog(null, "digite o preço do item: "));
        itemm item = new itemm(nome, at, p);
        item.exibir();
    }
}
class itemm{
    private String n;
    private int ataque;
    private double p;
    public itemm(String n, int a, double p){
        this.n=n;
        this.ataque=a;
        this.p=p;
    }
    public void exibir(){
        JOptionPane.showMessageDialog(null, "nome: "+this.n+"\n dano: "+this.ataque+"\n preço: "+this.p);
    }
}