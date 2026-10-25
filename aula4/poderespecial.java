package aula4;
import javax.swing.JOptionPane;
public class poderespecial {
    public static void main(String[] args) {
        String s=JOptionPane.showInputDialog("digite o nome do poder: ");
        int custo=Integer.parseInt(JOptionPane.showInputDialog("digite o custo de mana desse poder: "));
        pe p = new pe(s,custo);
        JOptionPane.showMessageDialog(null, "nome do poder: "+p.getn()+" \ncusto de mana: "+p.getc());
        String n=JOptionPane.showInputDialog("digite o nome do herói: ");
        int vida=Integer.parseInt(JOptionPane.showInputDialog("digite a vida do heroi: "));
        hcp h= new hcp(n,vida,p);
        JOptionPane.showMessageDialog(null, "heroi: "+h.getn()+" \nvida: "+h.getv()+" \n poder: "+h.getp().getn());
        h.up();
    }
}
class pe{
    private String nome;
    private int custo;
    public pe(String s, int c){
        setnome(s);
        setcusto(c);
    }
    public void setnome(String s){
        if(s==null || s.equals("")){
            this.nome="Poder desconhecido";
        }else{
            this.nome=s;
        }
    }
    public void setcusto(int c){
        if(c<0 || c>100){
            JOptionPane.showMessageDialog(null, "custo invalido:");
            c=10;
            this.custo=c;
        }else{
            this.custo=c;
        }
    }
    public String getn(){
        return this.nome;
    }
    public int getc(){
        return this.custo;
    }
}


                                    // heroi com poder //


class hcp{
    private String nome;
    private int vida;
    private pe poder;
    public hcp(String s, int v, pe poder){
        setn(s);
        setv(v);
        setp(poder);
    }
    public void setn(String s){
        this.nome=s;
    }
    public void setv(int v){
        this.vida=v;
    }
    public void setp(pe poder){
        this.poder=poder;
    }
    public void up(){
        JOptionPane.showMessageDialog(null, this.nome+" usou seu poder especial "+this.poder.getn()+" gastando um total de "+this.poder.getc()+" pontos de mana!");
    }
    public String getn(){
        return this.nome;
    }
    public int getv(){
        return this.vida;
    }
    public pe getp(){
        return this.poder;
    }
}
