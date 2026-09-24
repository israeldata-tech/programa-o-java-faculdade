import java.util.Scanner;
public class idade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite a sua idade em anos: ");
        int i = s.nextInt();
        System.out.println("digite sua idade em meses: ");
        int m = s.nextInt();
        System.out.println("digite a quantidade de dias: ");
        int d = s.nextInt();
        int dias = (i*365)+(m*30)+d;
        System.out.println("sua idade em dias é: "+dias);
        s.close();
    }
}
