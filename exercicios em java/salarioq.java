import java.util.Scanner;
public class salarioq {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite seu salario: ");
        double sal = s.nextDouble();
        
        double qtd = sal /  1600.0;
        
        System.out.println("voce recebe: "+qtd+" salarios minimos");
        s.close();
    }
}
