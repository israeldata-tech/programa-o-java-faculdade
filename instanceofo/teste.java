package instanceofo;
import java.util.Scanner;
public class teste {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite o nome do item");
        String n =s.nextLine();
        System.out.println("digite a quantidade do item:");
       int q = s.nextInt();
       espada i = new espada(n,q);
       i.preparar(i);
    }
}
class item{
    protected String nome;
    protected int qtd;
    public item (String n, int q){
        this.nome=n;
        this.qtd=q;
    }
public void preparar(item i){
System.out.println("item embalado "+i.nome);
if(i instanceof espada){
    espada e = (espada)i;
    e.amolar();
}else{
    System.out.println("item não é espada");
}
}

}
class espada extends item{
    
    public espada(String n, int q){
        super(n, q);
    }
    public void amolar(){
        System.out.println("espada "+this.nome+" amolada");
    }
}