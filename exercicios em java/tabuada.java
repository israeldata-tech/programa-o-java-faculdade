import java.util.Scanner;
public class tabuada {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("digite um número para ver a sua tabuada: ");
        double n = l.nextDouble();
        System.out.println("digite até que número quer ver a tabuada: ");
        int f = l.nextInt();
        for(int i = 1; i <= f; i++){
            double val = i * n;
            System.out.println(n +" " + "x" + " " + i + " " + "=" + " " + val);
        }
        l.close();
    }
}
