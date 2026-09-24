import java.util.Scanner;
public class ivro {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("digite o nome do livro: ");
        String n = s.nextLine();
        System.out.println("digite o autor: ");
        String a = s.nextLine();
        System.out.println("digite a quantidade de paginas: ");
        int qtd = s.nextInt();
        Livro l = new Livro(n, a, qtd);
        System.out.println();
        if(l.emprestar()){
            System.out.println("livro emprestado");
        } else{
            System.out.println("indisponivel.");
        }
        l.devolver();
        l.exibir();
        s.close();
    }
}
class Livro{
    String titulo;
    String autor;
    int paginas;
    boolean disp;
    public Livro(String titulo, String autor, int paginas){
        this.titulo=titulo;
        this.autor=autor;
        this.paginas=paginas;
        this.disp=true;
    }
    public boolean emprestar(){
        if(disp){
            System.out.println("disponivel1");
            this.disp=false;
            return true;
        } else{
            System.out.println("não disponível!");
            return false;
        }
    }
    public void devolver(){
        
            System.out.println("devolvido");
            disp = true;
        
    }
    public void exibir(){
        System.out.println("titulo: "+this.titulo);
        System.out.println("autor: "+this.autor);
        System.out.println("quantidade de pagina: "+this.paginas);
    
    }
}
