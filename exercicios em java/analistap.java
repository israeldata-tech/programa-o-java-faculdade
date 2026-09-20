import java.util.Scanner;
public class analistap {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("digite quantas pessoas quer analisar: ");
        int q = l.nextInt();
        l.nextLine();
        int soma =0;
        int mv =0;
        int mn = 0;
        int qtdh = 0;
        int qtdm = 0;
        String pmv = "";
        String pmn = "";
        int qtdpmi = 0;

        for(int i=0;i<q;i++){
            System.out.println("digite o nome da pessoa "+(i+1)+": ");
            String nome = l.nextLine();
            System.out.println("digite o sexo da pessoa (h: homem/m:mulher): ");
            String sexo = l.nextLine();
            System.out.println("digite a idade dessa pessoa: ");
            int idade = l.nextInt();
            l.nextLine();
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
            if(sexo.equalsIgnoreCase("h")){
                    qtdh ++;
                } else{
                    qtdm++;
                }
                if (idade >= 18){
                    qtdpmi++;
                }
        }
        double med = (1.0*soma) / q;
        System.out.println("existem um total de "+(qtdh+qtdm)+" pessoas e "+ qtdpmi+" maior(es) de idade");
        System.out.println("dentre elas,"+(qtdh)+" são homens e "+(qtdm)+" são mulheres");
        System.out.println("a média de idade entre essas pessoas é: "+med);
        System.out.println("a pessoa mais velha é:"+pmv+" com "+ mv+" anos");
        System.out.println("a pessoa mais nova é: "+pmn+" com "+ mn+ " anos");
        
        l.close();
    }
}
