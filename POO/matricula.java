import java.util.Scanner;
public class matricula {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite quantos alunos quer analisar: ");
        int q = s.nextInt();
        s.nextLine();
        int qtda=0;
        int qtdd=0;
        for(int i=0;i<q;i++){
            double soma=0;
            System.out.println("digite o nome do aluno: ");
            String n = s.nextLine();
            System.out.println("digite a matricula do aluno: ");
            int mat=s.nextInt();
            System.out.println("digite quantas notas desse aluno quer inserir: ");
            int qt=s.nextInt();
            for(int j=0;j<qt;j++){
                System.out.println("digite a nota "+j+" :");
                double nota=s.nextDouble();
                soma+=nota;

            }
            analisar a= new analisar(n, mat, soma, qt);
            System.out.println("digite 1 se a matricula esta cancelada e 0 se estiver ativa: ");
            int st =s.nextInt();
            System.out.println();
            if(st==1){
                qtdd++;
            } else{
                qtda++;
            }
            a.trancar(st);

            a.resumo();
            s.nextLine();
        }
        System.out.println("===== RELÁTORIO GERAL =====");
        System.out.println("temos um total de "+qtda+" alunos ativos.");
        System.out.println("temos um total de "+qtdd+" alunos desistentes");
        s.close();
    }
}
class analisar{
String nome;
int matricula;
double soma;
int qtdn;

boolean ativo;
public analisar(String nome, int matricula, double soma, int qtdn){
    this.nome=nome;
    this.matricula=matricula;
    this.soma=soma;
    this.qtdn=qtdn;
    this.ativo=true;
}
public double calcularmedia(){

    return this.soma/this.qtdn;
}
public String status(){
    double m = calcularmedia();
    if(m>=7.0){
        return "aprovado";
    } else if(m>=4 && m<7){
return "recuperação";
    } else{
        return "reprovado";
    }
}
public void trancar(int v){
    if(v==1){
        this.ativo=false;
    }else{
        this.ativo=true;
    }
}
public void resumo(){
    System.out.println("nome do aluno: "+this.nome);
    System.out.println("matricula: "+this.matricula);
    System.out.println("média geral: "+calcularmedia());
    System.out.println("Status: "+status());
    System.out.println("status de matricula: "+(this.ativo?"ativa":"trancada"));
    System.out.println();
}

}
