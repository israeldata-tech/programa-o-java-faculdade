package encapsulamento;
import java.util.Scanner;
public class enc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite o nome: ");
        String d = s.nextLine();
        System.out.println("digite a quantidade de linhas");
        int q = s.nextInt();
        dataset a = new dataset(d,q);
        a.setnome(d);
        a.settotal(q);
        System.out.println("o nome é : "+a.getnome());
        System.out.println("quantidade de linhas: "+a.gettotal());
        s.close();
    }
}
class dataset{
    private String nome;
    private int total;
    public dataset(String nome, int total){
    this.nome=nome;
    this.total=total;
    }
    public String getnome(){
        return this.nome;
    }
    public int gettotal(){
        return this.total;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public void settotal(int total){
        if(total>0){
            this.total=total;
        }else{
            System.out.println("quantidade de linhas tem que ser maior que zero.");
        }
    }

}
