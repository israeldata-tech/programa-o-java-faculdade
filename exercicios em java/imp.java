import java.util.Scanner;
public class imp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite a quantidade de peças para compra: ");
        int qtdp = s.nextInt();
        System.out.println("digite um desconto para o tipo 1: ");
        double d1 = s.nextDouble();
        System.out.println("digite um desconto para o tipo 2: ");
        double d2 = s.nextDouble();
        double soma = 0;
        int qtd1 = 0;
        int qtd2=0;

        for(int i=0;i<qtdp;i++){
            System.out.println("digite o valor da peça: ");
            double p = s.nextDouble();
            System.out.println("digite se é do tipo 1 ou tipo 2:");
            int t = s.nextInt();
            if(t==1){
                qtd1++;
                soma+=(p*(1+(d1/100)));
            }else{
                qtd2++;
                soma+=(p*(1+(d2/100)));
            }
        }
        System.out.println("quantidade de peças 1: "+qtd1);
        System.out.println("quantidade de peças 2: "+qtd2);
        System.out.println("valor total a pagar: %.2f"+soma);
        s.close();
        

    }
}
