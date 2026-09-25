import java.util.Scanner;
public class combate {
    public static void main(String[] args) {
        personagem p1 = new personagem();

    }
}
class personagem{
    String nome;
    String classe;
    int vida;
    int vidam;
    double pa;
    int qtdp;
    double forçap;
    public void receberataque(double ataque){
        vida-=ataque;
        if(vida<0){
            vida=0;
            System.out.println(nome+" FOI DERROTADO!!!");
        }  
        if(vida>0){
            System.out.println(nome+" RECEBEU "+ataque+" DE DANO!!!");
        }
    }
    public void guardarpoção(int q){
        qtdp+=q;
    }
    public void usarpoção(){
        if(vida>0){
        if(qtdp>0){
            qtdp--;
            vida+=forçap;
            System.out.println(nome+" USOU UMA POÇÃO E RECUPEROU SAÚDE, VIDA ATUAL: "+vida+" DE "+vidam);
            if(vida>vidam){
                vida=vidam;
                System.out.println(nome+" ESTÁ COM A VIDA CHEIA , NÃO É POSSIVEL USAR POÇÃO!!!");
            }
            }
        }
    }
    public void atacar(String alvo){
        System.out.println(nome+" ATACOU "+alvo+" causando um total de "+pa+" PONTOS DE DANO!!!");
        receberataque(pa);
    }
}
