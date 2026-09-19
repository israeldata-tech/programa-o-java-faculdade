import java.util.Scanner;
public class analistap {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("digite quantas pessoas quer analisar: ");
        int q = l.nextInt();
        int soma =0;
        int mv =0;
        int mn = 0;
        int qtdh = 0;
        int qtdm = 0;
        String pmv;
        String pmn;

        for(int i=0;i<q;i++){
            System.out.println("digite o nome da pessoa "+(i+1)+": ");
            String nome = l.nextLine();
            System.out
            System.out.println("digite a idade dela: ");
            int idade = l.nextInt();
            soma += idade;
            if (i==0){
                mv = idade;
                mn = idade;
                pmv = nome;
                pmn = nome;
            } else{
                if(idade > mv){
                    mv = idade;
                    pmv = nome;
                }
                if(idade < mn){
                    mn = idade;
                    pmn = nome;
                }
            }
        }
    }
}
