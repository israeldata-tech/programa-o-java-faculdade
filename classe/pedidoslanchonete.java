import java.util.Scanner;
public class pedidoslanchonete {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite a quantidade de pedidos: ");
        int q = s.nextInt();
        s.nextLine();
        double soma = 0;
        for (int i =0;i<q;i++){
            pedidos p = new pedidos();
            System.out.println("digite o nome do cliente: ");
            p.nomec=s.nextLine();
            System.out.println("digite o pedido: ");
            p.item=s.nextLine();
            System.out.println("digite o preço: ");
            p.preço=s.nextDouble();
            System.out.println("digite a quantidade de pedidos: ");
            p.qtd=s.nextInt();
            s.nextLine();
            soma+=p.calct(p.qtd);
            System.out.println();
            p.comprovante();
        }
        System.out.println("valor total a pagar: "+soma);
        s.close();
    }
}
class pedidos{
    String nomec;
    String item;
    double preço;
    int qtd;
    public double calct(int qtdi){
        return preço * qtdi;
    }
    public void comprovante(){
        System.out.println("nome do cliente: "+nomec);
        System.out.println("pedido: "+item);
        System.out.println("valor do pedido a pagar: "+calct(qtd));
    }
}
