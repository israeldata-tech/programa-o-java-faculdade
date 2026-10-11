// Autor: Francisco israel de almeida costa (2026003459)
package arena;

public class TesteEtapa3 {
    public static void main(String[] args) {
        Guerreiro thorin = new Guerreiro("Thorin", 120, 15, 5, 3);
        Personagem vampiro = new Personagem("Vamp", 120, 15, 5);
        Mago merlin = new Mago("Merlin", 70, 12, 2, 20);
        Arqueiro legolas = new Arqueiro("Legolas", 85, 13, 3, 1);
        Personagem orc = new Personagem("Orc", 300, 18, 4);

        orc.atacar(vampiro);
        orc.atacar(thorin);
        merlin.atacar(orc);
        merlin.atacar(orc);
        merlin.atacar(orc);
        legolas.atacar(orc);
        legolas.atacar(orc);

        System.out.println(orc.status());
    }
}
