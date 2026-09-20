
import java.util.Scanner;
public class ClassA {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("digite a quantidade de alunos para cadastro: ");
        int q = l.nextInt();
        l.nextLine();
        
        for(int i = 0;i<q;i++){
            Aluno aluno = new Aluno();
            double soma = 0;
            System.out.println("===== ALUNO "+(i+1)+" =====");
            System.out.println("digite o nome do aluno "+ (i+1)+": ");
            String n = l.nextLine();
            aluno.nome = n;
            System.out.println("digite a matricula desse aluno: ");
            int m = l.nextInt();
            aluno.matricula=m;
            System.out.println("digite quantas notas quer cadastrar desse aluno: ");
            int qtdn = l.nextInt();
            l.nextLine();
            for(int j=0;j<qtdn;j++){
                System.out.println("digite a nota "+(j+1)+": ");
                double nota = l.nextDouble();
                
                soma += nota;
            }
            l.nextLine();
            double media = (soma*1.0)/ qtdn;
            aluno.mg=media;
            System.out.println("===== DADOS DO ALUNO "+(i+1)+" =====");
            System.out.println("nome do aluno: "+aluno.nome);
            System.out.println("matricula: "+aluno.matricula);
            System.out.println("média geral: "+aluno.mg);
            System.out.println();
        }
        l.close();
    }
}
class Aluno{
    String nome;
    int matricula;
    double mg;
    
}

