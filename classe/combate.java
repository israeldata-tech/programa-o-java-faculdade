import java.util.Scanner;
public class combate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        personagem p1 = new personagem();
        personagem p2 = new personagem();
        System.out.println("digite o nome do primeiro personagem: ");
        p1.nome=s.nextLine();
        System.out.println("digite o nome da classe do primeiro personagem: ");
        p1.classe=s.nextLine();
        System.out.println("digite a vida maxima do primeiro personagem: ");
        p1.vidam=s.nextInt();
        p1.vida=p1.vidam;
        System.out.println("digite quantos pontos de ataque o primeiro personagem tem: ");
        p1.pa=s.nextDouble();
        System.out.println("VOCE ENCONTROU UMA LOJA, QUANTAS POÇÕES COMPRA?");
        p1.qtdp=s.nextInt();
        System.out.println("QUAL A FORÇA DESSAS POÇÕES? ");
        p1.forçap=s.nextDouble();
        s.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("digite o nome do segundo personagem: ");
        p2.nome=s.nextLine();
        System.out.println("digite o nome da classe do segundo personagem: ");
        p2.classe=s.nextLine();
        System.out.println("digite a vida maxima do segundo personagem: ");
        p2.vidam=s.nextInt();
        p2.vida=p2.vidam;
        System.out.println("digite quantos pontos de ataque o segundo personagem tem: ");
        p2.pa=s.nextDouble();
        System.out.println("VOCE ENCONTROU UMA LOJA, QUANTAS POÇÕES COMPRA?");
        p2.qtdp=s.nextInt();
        System.out.println("QUAL A FORÇA DESSAS POÇÕES? ");
        p2.forçap=s.nextDouble();
        System.out.println("===== COMBATE INICIOU =====");
        int i =1;
        while(p1.vida>0 && p2.vida>0){
            
            System.out.println("TURNO "+i+" :");
            p1.atacar(p2);
            if(p2.vida<=0) break;
            p1.usarpoção();
            System.out.println();

            
            p2.atacar(p1);
            if(p1.vida<=0)break;
            p2.usarpoção();
            
            System.out.println("FIM DO TURNO "+i+"\n ");
            i++;
        }
        s.close();
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
        if(vida<=0){
            vida=0;
            System.out.println(classe+" "+nome+" FOI DERROTADO!!!");
        }  
        if(vida>0){
            System.out.println(classe+" "+nome+" RECEBEU "+ataque+" DE DANO!!!");
        }
    }
    
    public void usarpoção(){
        if(vida>0 && qtdp>0){
        if(vida>=vidam){
                System.out.println(classe+" "+nome+" ESTÁ COM A VIDA CHEIA , NÃO É POSSIVEL USAR POÇÃO!!!");
            }else{
            qtdp--;
            vida+=forçap;
            if(vida>vidam){
                vida=vidam;
            }
            System.out.println(classe+" "+nome+" USOU UMA POÇÃO E RECUPEROU SAÚDE, VIDA ATUAL: "+vida+"/"+vidam);
            }
            
        }
    }
    public void atacar(personagem alvo){
        System.out.println(classe+" "+nome+" ATACOU "+alvo.classe+" "+alvo.nome+" causando um total de "+pa+" PONTOS DE DANO!!!");
        alvo.receberataque(this.pa);
    }
}
