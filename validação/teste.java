package validação;
import java.util.Scanner;
public class teste {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("digite um número inteiro.");
           
            if(s.hasNextInt()){
                int i= s.nextInt();
                int v = i;
                System.out.println(v);
                break;
            }else{
                System.out.println("voce não digitou um número inteiro:");
                s.next();
            }
        }
        s.close();
    }
    
}
