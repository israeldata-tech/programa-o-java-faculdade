
import java.util.Scanner;
public class ClassA {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("digite a quantidade de alunos para cadastro: ");
        int q = l.nextInt();
        l.nextLine();
        double soma = 0;
        for(int i = 0;i<q;i++){
            Aluno aluno = new Aluno();
            System.out.println("digite o nome do aluno "+ (i+1)+": ");
            String n = l.nextLine();
            aluno.nome = n;
            System.out.println("digite a matricula desse aluno: ");
            int m = l.nextInt();
            System.out.println("digite quantas notas quer cadastrar desse aluno: ");
            int qtdn = l.nextInt();
            for(int j=0;j<qtdn;j++){
                System.out.println("digite a nota "+(i+1)+": ");
                double nota = l.nextDouble();
                soma += nota;
            }
        }
    }
}
class Aluno{
    String nome;
    int matricula;
    double mg;
    
}

