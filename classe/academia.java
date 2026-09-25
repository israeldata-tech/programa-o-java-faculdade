import java.util.Scanner;
public class academia {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite quantos alunos quer registrar: ");
        int q = s.nextInt();
        s.nextLine();
        for(int i=0;i<q;i++){
            Alunoacademia a = new Alunoacademia();
            System.out.println("digite o nome do aluno: ");
            a.nome=s.nextLine();
            System.out.println("digite a quantidade de dias treinados: ");
            a.diast=s.nextInt();
            System.out.println("digite a meta semanal: ");
            a.metas=s.nextInt();
            if(a.atingiumeta()){
                System.out.println(a.nome+" atingiu a meta semanal! ");
            } else{
                System.out.println(a.nome+" não atingiu a meta! ");
            }
            
            System.out.println("digite quantos dias quer registrar de treino: ");
            int r = s.nextInt();
            a.registrart(r);
            if(a.atingiumeta()){
                System.out.println(a.nome+" atingiu a meta! ");
            } else{
                System.out.println(a.nome+" não atingiu a meta!");
            }
        
        s.nextLine();
        }
        s.close();
        
    }
}
class Alunoacademia{
    String nome;
    int diast;
    int metas;
    public void registrart(int qtd){
        this.diast+=qtd;
    }
    public boolean atingiumeta(){
        if(diast>=metas){
            return true;
        } else{
            return false;
        }
    }
}