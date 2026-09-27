package encapsulamento;
import java.util.Scanner;
public class avaliadorml {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite o nome do modelo: ");
        String n = s.nextLine();
        System.out.println("digite o valor da acuracia: ");
        double ac =s.nextDouble();
        Modeloml m = new Modeloml(n, ac/100);
        avaliarmodelo a = new avaliarmodelo(m);
        a.relatorio();
        s.close();

    }
}
class Modeloml{
    private String nome;
    private double acuracia;
    public Modeloml(String nome, double acuracia){
        setnome(nome);
        setacuracia(acuracia);
    }
    public String getmodelo(){
        return this.nome;
    }
    public double getacuracia(){
        return this.acuracia;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public void setacuracia(double acuracia){
        if(acuracia>=0 && acuracia<=1){
            this.acuracia=acuracia;
        }else{
            System.out.println("erro no valor da acuracia.");
        }
    }
}
class avaliarmodelo{
private Modeloml modelo;
public avaliarmodelo(Modeloml modelo){
    this.modelo=modelo;
}
public boolean retornarvalor(){
    return this.modelo.getacuracia()>=0.80;
}
public void relatorio(){
    System.out.println("nome do modelo: "+this.modelo.getmodelo());
    System.out.println("acurácia: "+this.modelo.getacuracia()*100+"%");
    System.out.println("Status: "+(retornarvalor()? "aprovado":"reprovado"));
}
}
