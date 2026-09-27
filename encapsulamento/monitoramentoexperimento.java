package encapsulamento;
import java.util.Scanner;
public class monitoramentoexperimento {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("digite o nome do experimento: ");
        String n = s.nextLine();
        System.out.println("digite o tempo de execução em segundos: ");
        double t = s.nextDouble();
        metricaexp m= new metricaexp(n, t);
        relatorio r = new relatorio(m);
        r.resumo();
        s.close();
    }
}
class metricaexp{
    private String nome;
    private double tempexec;
    public metricaexp(String n, double t){
        setnome(n);
        settempexec(t);
    }
    public String getnome(){
        return this.nome;
    }
    public double gettempexc(){
        return this.tempexec;
    }
    public void setnome(String n){
        this.nome=n;
    }
    public void settempexec(double t){
        if(t>0)
            {this.tempexec=t;
            }else{
                System.out.println("tempo de execução invalido.");
            }
    }
}
class relatorio{
    private metricaexp metrica;
    public relatorio(metricaexp metrica){
        this.metrica=metrica;
    }
    public boolean performatico(){
        return this.metrica.gettempexc() <=5;
    }
    public void resumo(){
        System.out.println("nome do experimento: "+this.metrica.getnome());
        System.out.println("tempo de execução: "+this.metrica.gettempexc());
        System.out.println("status: "+(performatico()? "alta performance":"precisa de otimização"));
    }
}