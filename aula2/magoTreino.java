package aula2;

import javax.swing.JOptionPane;

public class magoTreino {
    public static void main(String[] args) {
        String n=JOptionPane.showInputDialog("digite o nome do mago: ");
        int pm=Integer.parseInt(JOptionPane.showInputDialog("digite o poder mágico dele: "));
        int f= Integer.parseInt(JOptionPane.showInputDialog("digite quanto de mana quer gastar no feitiço: "));
        mago mage=new mago(n,pm);
        mage.gastarmana(f);
        mage.exibir();
    }
}
class mago{
    private String n;
    private int mana;
    private int pm;
    public mago(String no, int p){
        this.n=no;
        this.mana=100;
        this.pm=p;
    }
public void gastarmana(int g){
    if(g>this.mana){
        JOptionPane.showMessageDialog(null, this.n+" não possui mana para esse feitiço!");

    }
    else{
        this.mana-=g;
        JOptionPane.showMessageDialog(null, this.n+" gastou "+g+" de mana e realizou o feitiço! mana restante: "+this.mana);
    }
}
public void exibir(){
    JOptionPane.showMessageDialog(null, "mago: "+this.n+" \npoder mágico: "+this.pm+" \nmana: "+this.mana);
}
}