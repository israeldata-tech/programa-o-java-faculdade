package encapsulamento;
import java.util.Scanner;
public class pipelined {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite o nome do pipeline: ");
        String n = s.nextLine();
        System.out.println("digite o espaço total em GB: ");
        double e = s.nextDouble();
        System.out.println("digite o preço por GB: ");
        double ppg = s.nextDouble();
        pipelinedados p = new pipelinedados(n, e);
        calcularcusto c = new calcularcusto(p);
        c.exibir(ppg);
        s.close();
    }
}
class pipelinedados{
    private String nome;
    private double gb;
    public pipelinedados(String n, double e){
        setnome(n);
        setgb(e);
    }
    public String getnome(){
        return this.nome;
    }
    public double getgb(){
        return this.gb;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public void setgb(double e){
        if(e>0){
            this.gb=e;
        }else{
            System.out.println("armazenamento invalido.");
        }
    }
}
class calcularcusto{
    private pipelinedados pipeline;
    public calcularcusto(pipelinedados p){
        this.pipeline=p;
    }
    public double calcular(double ppg){
        return this.pipeline.getgb()*ppg;
    }
    public void exibir(double ppg){
        System.out.println("nome do Pipeline: "+this.pipeline.getnome());
        System.out.println("volume de GB: "+this.pipeline.getgb());
        System.out.println("preço por GB: "+ppg);
        System.out.println("custo total:"+calcular(ppg));
    }
}