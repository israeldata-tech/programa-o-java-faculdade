import java.util.Scanner;
public class sistcontcarro {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        carro c = new carro();
        System.out.println("digite o modelo do carro: ");
        String nome = s.nextLine();
        c.modelo=nome;
        System.out.println("digite a velocidade atual do veiculo: ");
        double v = s.nextDouble();
        c.vela=v;
        System.out.println("digite o nivel de gasolina atual: ");
        double g = s.nextDouble();
        c.comb = g;
        System.out.println();

        System.out.println("digite quanto pretende acelerar: ");
        double a = s.nextDouble();
        if (c.acelerar(a)){
            System.out.println("velocidade aumentada!");
        } else{
            System.out.println("sem gasolina!");
        }
        System.out.println("digite quanto pretende abastecer: ");
        double ab = s.nextDouble();
        c.abastecer(ab);
        c.exibir();
        s.close();
    }
}
class carro{
    String modelo;
    double vela;
    double comb;

    public boolean acelerar(double vel){
        if (comb > 0){
            vela+=vel;
            comb -= 1;
            return true;
        } else{
return false;
        }
    }
    public void abastecer(double a){
        comb += a;
        System.out.println("abastecido um total de R$"+a+" litros");
    }
    public void exibir(){
        System.out.println("modelo: "+modelo);
        System.out.println("velocidade atual: "+vela);
        System.out.println("nível de combustivel: "+comb);
    }
}
