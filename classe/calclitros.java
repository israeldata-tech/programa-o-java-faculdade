import java.util.Scanner;
public class calclitros {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        viajem v = new viajem();
        System.out.println("digite o destino da viajem: ");
        v.destino=s.nextLine();
        System.out.println("digite a distancia em KM: ");
        v.distancia=s.nextDouble();
        System.out.println("digite o consumo do transporte em litros por KM: ");
        v.consumokml=s.nextDouble();
        System.out.println("digite o preço da gasolina: ");
        v.preçog=s.nextDouble();
        System.out.println("voce precisara de "+v.calcularlitros()+" litros de gasolina para sua viajem até "+v.destino);
        System.out.println("voce pagará "+v.calculartotal()+" reais de gasolina para sua viajem até "+v.destino);
        s.close();
    }
}
class viajem{
    String destino;
    double distancia;
    double consumokml;
    double preçog;
    public double calcularlitros(){
        return distancia/consumokml;
    }
    public double calculartotal(){
        return calcularlitros()*preçog;
    }
}
