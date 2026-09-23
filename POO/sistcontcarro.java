import java.util.Scanner;
public class sistcontcarro {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
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
