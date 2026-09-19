import java.util.Scanner;
public class MaiorMenor {
    public static void main(String[] args){
        Scanner l = new Scanner(System.in);
        System.out.println("digite quantos números quer digitar: ");
        int n = l.nextInt();
        double maior;
        double menor;
        for(int i=0;i<n;i++){
            System.out.println("digite o numero"+ i+1+": ");
            double d = l.nextDouble();
            if(i==1){
            maior = d;
            menor = d;
            }
            if(d > maior){
                maior = d;
            }
            if(d < menor){
                menor = d;
            }
        }
    }
}
