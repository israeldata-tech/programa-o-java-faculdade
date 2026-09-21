import java.util.Scanner;
public class estoquel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        produto p = new produto();
        System.out.println("digite o nome do produto: ");
        String n = s.nextLine();
        p.nome = n;
        System.out.println("digite o preço do produto: ");
        double pr = s.nextDouble();
        p.preco=pr;
        System.out.println("digite a quantidade em estoque: ");
        int q = s.nextInt();
        p.qtde=q;

        System.out.println("===== COMPRA =====");
        System.out.println("digite quantos itens quer adicionar no estoque: ");
        int qn = s.nextInt();
        p.adde(qn);
        System.out.println("digite quantos itens quer comprar: ");
        int v = s.nextInt();
        if (p.vender(v) == true){
            System.out.println("temos em estoque");

        } else{
            System.out.println("não temos essa quantia em estoque");
        }
        p.ficha();
        s.close();


    }
}
class produto{
    String nome;
    double preco;
    int qtde;
    public void adde(int est){
        this.qtde+=est;
        System.out.println("recebido uma quantidade de "+est+" desse item.");
    }
    public boolean vender(int qtd){
    if(this.qtde>=qtd){
        this.qtde-=qtd;
        return true;
    } else{
        return false;
    }
    }
    public double investimento(){
        return preco * qtde;
    }
    public void ficha(){
        System.out.println("nome do produto:"+nome);
        System.out.println("preço: "+preco);
        System.out.println("quantidade em estoque: "+qtde);
        double vte = investimento();
        System.out.println("valor total em estoque: "+vte);
    }

}
