import java.util.Scanner;
public class datasm {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("digite o nome da tabela: ");
        String n = s.nextLine();
        System.out.println("quantidade de linhas e colunas(respectivamente): ");
        int qtdl=s.nextInt();
        int qtdc=s.nextInt();
        Dataset d = new Dataset(n, qtdl, qtdc);
        d.criarPipeline();
        d.resumo();
        s.close();
    }
}
class Dataset{
String nometabela;
int qtdl;
int qtdc;
boolean proc;
    public Dataset(String nome,int qtdl, int qtdc){
    this.nometabela=nome;
    this.qtdl=qtdl;
    this.qtdc=qtdc;
    this.proc=false;
}
public void criarPipeline(){
    this.proc=true;
    System.out.println("Pipeline executado em "+this.nometabela);
}
public int tamanhototal(int qtdl, int qtdc){
    return this.qtdl*this.qtdc;
}
public void resumo(){
    System.out.println("nome da tabela: "+this.nometabela);
    System.out.println("numero de linhas: "+this.qtdl);
    System.out.println("numero de colunas: "+this.qtdc);
    System.out.println("total de elementos: "+tamanhototal(this.qtdl, this.qtdc));
    if(this.proc){
        System.out.println("processado!");
    }else{
        System.out.println("não processado!");
    }
}
}
