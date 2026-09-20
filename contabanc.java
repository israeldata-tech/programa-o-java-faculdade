import java.util.Scanner;
public class contabanc {
    public static void main(String[] args) {
        Scanner l= new Scanner(System.in);
        contabancaria c = new contabancaria();
        System.out.println("digite o nome do titular: ");
        String nome = l.nextLine();
        System.out.println("digite o numero da conta: ");
        int nc = l.nextInt();
        System.out.println("digite o saldo da conta");
        double saldo = l.nextDouble();
        c.titular = nome;
        c.numc = nc;
        c.saldo = saldo;
        System.out.println("===== banco =====");
        System.out.println("DIGITE UM VALOR PARA DEPOSITO: ");
        double vdep = l.nextDouble();
        c.depositar(vdep);
        System.out.println("digite um valor para saque: ");
        double vs = l.nextDouble();
        
        if(c.sacar(vs)){
            System.out.println("saque realizado!");
        } else{
            System.out.println("saldo indisponivel!");
        }
        c.exibirextrato();
        l.close();
    }
}
class contabancaria{
    String titular;
    int numc;
    double saldo;
    public void depositar(double valor){
    this.saldo+=valor;
    System.out.println("depositado um total de "+ valor+" reais");
    System.out.println();
    }
    public boolean sacar(double valor){
        if (saldo >= valor){
            saldo -= valor;
            return true;
        } else{
            return false;
        }
    }
    public void exibirextrato(){
        System.out.println("nome do titular: "+this.titular);
        System.out.println("número da conta: "+numc);
        System.out.println("seu saldo atual é de: "+this.saldo);
        
    }
}
