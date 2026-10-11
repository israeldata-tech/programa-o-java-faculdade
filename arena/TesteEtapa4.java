// Autor: Francisco israel de almeida costa (2026003459)
package arena;

public class TesteEtapa4 {
    public static void main(String[] args) {
        Personagem[] equipe = new Personagem[3];
        equipe[0] = new Guerreiro("Thorin", 120, 15, 5, 3);
        equipe[1] = new Mago("Merlin", 70, 12, 2, 30);
        equipe[2] = new Arqueiro("Legolas", 85, 13, 3, 2);

        Personagem doll = new Personagem("dolin", 300, 0, 4);

        for (int rodada = 1; rodada <= 4; rodada++) {
            System.out.println("--- Turno " + rodada + " ---");
            for (Personagem p : equipe) {
                p.atacar(doll);
            }
            System.out.println(doll.status());
        }
    }
}
