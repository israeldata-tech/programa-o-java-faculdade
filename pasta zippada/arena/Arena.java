package arena;
import java.util.Scanner;

public class Arena {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Personagem[] herois = new Personagem[] {
            new Guerreiro("Thorin", 120, 15, 5, 3),
            new Mago("Merlin", 70, 12, 2, 40),
            new Arqueiro("Legolas", 85, 13, 3, 5)
        };

        Personagem[] monstros = new Personagem[] {
            new Personagem("Goblin", 40, 12, 2),
            new Personagem("Orc", 80, 18, 4),
            new Personagem("Troll", 140, 22, 6)
        };

        int turno = 1;

        while (algumVivo(herois) && algumVivo(monstros)) {
            System.out.println("===== TURNO " + turno + " =====");
            mostrarTimes(herois, monstros);
            for (Personagem h : herois) {
                if (h.estaVivo() && algumVivo(monstros)) {
                    System.out.println("Vez de " + h.status() + ": 1) Atacar 2) Habilidade especial");
                    int opcao = 0;
                    while (opcao != 1 && opcao != 2) {
                        System.out.print("> ");
                        if (s.hasNextInt()) {
                            opcao = s.nextInt();
                        } else {
                            s.next();
                        }
                    }

                    if (opcao == 1) {
                        System.out.print("Escolha o alvo (número): > ");
                        Personagem alvo = escolherAlvo(monstros, s);
                        h.atacar(alvo);
                    } else {
                        usarHabilidade(h, herois, s);
                    }
                }
            }

            if (algumVivo(monstros) && algumVivo(herois)) {
                for (Personagem m : monstros) {
                    if (m.estaVivo()) {
                        Personagem alvoMaisFraco = maisFraco(herois);
                        if (alvoMaisFraco != null) {
                            m.atacar(alvoMaisFraco);
                        }
                    }
                }
            }

            turno++;
        }

        int turnosTotais = turno - 1;
        if (algumVivo(herois)) {
            System.out.println("VITÓRIA! Os heróis venceram em " + turnosTotais + " turnos.");
        } else {
            System.out.println("DERROTA... os monstros dominaram a arena.");
        }

        s.close();
    }

    public static boolean algumVivo(Personagem[] time) {
        for (Personagem p : time) {
            if (p.estaVivo()) return true;
        }
        return false;
    }

    public static void mostrarTimes(Personagem[] herois, Personagem[] monstros) {
        System.out.println("Heróis:");
        for (int i = 0; i < herois.length; i++) {
            System.out.println(i + ") " + herois[i].status());
        }
        System.out.println("Monstros:");
        for (int i = 0; i < monstros.length; i++) {
            System.out.println(i + ") " + monstros[i].status());
        }
    }

    public static Personagem escolherAlvo(Personagem[] time, Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int idx = sc.nextInt();
                if (idx >= 0 && idx < time.length && time[idx].estaVivo()) {
                    return time[idx];
                }
            } else {
                sc.next();
            }
            System.out.print("Escolha o alvo (número): > ");
        }
    }

    public static Personagem maisFraco(Personagem[] time) {
        Personagem maisFraco = null;
        for (Personagem p : time) {
            if (p.estaVivo()) {
                if (maisFraco == null || p.getVida() < maisFraco.getVida()) {
                    maisFraco = p;
                }
            }
        }
        return maisFraco;
    }

    public static void usarHabilidade(Personagem p, Personagem[] herois, Scanner sc) {
        if (p instanceof Guerreiro) {
            Guerreiro g = (Guerreiro) p;
            g.gritoDeGuerra();
        } else if (p instanceof Mago) {
            Mago m = (Mago) p;
            System.out.print("Escolha o aliado (número): > ");
            Personagem aliado = escolherAlvo(herois, sc);
            m.curarAliado(aliado);
        } else if (p instanceof Arqueiro) {
            Arqueiro a = (Arqueiro) p;
            a.recarregar();
        }
    }
}