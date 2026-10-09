package arena;

public class TesteEtapa5 {
    public static void main(String[] args) {
        Personagem[] equipe = new Personagem[3];
        equipe[0] = new Guerreiro("Thorin", 120, 15, 5, 3);
        equipe[1] = new Mago("Merlin", 70, 12, 2, 30);
        equipe[2] = new Arqueiro("Legolas", 85, 13, 3, 0);

        Personagem dragao = new Personagem("Dragao", 500, 60, 10);
        dragao.atacar(equipe[0]);

        for (Personagem p : equipe) {
            usarHabilidade(p, equipe);
        }
    }

    public static void usarHabilidade(Personagem p, Personagem[] equipe) {
        if (p instanceof Guerreiro) {
            Guerreiro g = (Guerreiro) p;
            g.gritoDeGuerra();
        } else if (p instanceof Mago) {
            Mago m = (Mago) p;

            Personagem maisFraco = null;
            for (Personagem integrante : equipe) {
                if (integrante.estaVivo()) {
                    if (maisFraco == null || integrante.getVida() < maisFraco.getVida()) {
                        maisFraco = integrante;
                    }
                }
            }

            if (maisFraco != null) {
                m.curarAliado(maisFraco);
            }
        } else if (p instanceof Arqueiro) {
            Arqueiro a = (Arqueiro) p;
            a.recarregar();
        }
    }
}
