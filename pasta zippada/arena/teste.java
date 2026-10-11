package arena;

        import java.util.Scanner;

public class teste {

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

class Personagem {
    private String nome;
    private int vidam;
    private int vida;
    private int ataque;
    private int defesa;

    public Personagem(String n, int vm, int a, int d) {
        this.nome = n;
        this.vidam = vm;
        this.vida = vidam;
        this.ataque = a;
        this.defesa = d;
    }

    public String getNome() { return this.nome; }
    public int getVidaMaxima() { return this.vidam; }
    public int getAtaque() { return this.ataque; }
    public int getDefesa() { return this.defesa; }
    public int getVida() { return this.vida; }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public int receberDano(int dano) {
        int danor = dano - this.defesa;
        if (danor < 1) {
            danor = 1;
        }
        this.vida -= danor;
        if (this.vida < 0) {
            this.vida = 0;
        }
        return danor;
    }

    public void curar(int pontos) {
        if (!estaVivo()) {
            return;
        }
        this.vida += pontos;
        if (this.vida > this.vidam) {
            this.vida = this.vidam;
        }
    }

    public void atacar(Personagem alvo) {
        int danor = alvo.receberDano(this.ataque);
        System.out.println(this.nome + " ataca " + alvo.getNome() + " e causa " + danor + " de dano.");
    }

    public String status() {
        return this.nome + " [HP " + this.vida + "/" + this.vidam + "]";
    }

    protected void aumentarAtaque(int pontos) {
        this.ataque += pontos;
    }
}

class Guerreiro extends Personagem {
    private int armadura;

    public Guerreiro(String nome, int vidam, int ataque, int defesa, int arm) {
        super(nome, vidam, ataque, defesa);
        this.armadura = arm;
    }

    public int getArmadura() {
        return this.armadura;
    }

    @Override
    public int receberDano(int dano) {
        int danocarm = dano - this.armadura;
        if (danocarm < 1) {
            danocarm = 1;
        }
        return super.receberDano(danocarm);
    }

    public void gritoDeGuerra() {
        aumentarAtaque(5);
        System.out.println(getNome() + " solta um grito de guerra! Ataque agora: " + getAtaque() + ".");
    }
}

class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int vidam, int ataque, int defesa, int m) {
        super(nome, vidam, ataque, defesa);
        this.mana = m;
    }

    public int getMana() {
        return this.mana;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (this.mana >= 10) {
            this.mana -= 10;
            int força = getAtaque() * 2;
            int danor = alvo.receberDano(força);
            System.out.println(getNome() + " lança uma bola de fogo em " + alvo.getNome() + " e causa " + danor + " de dano. (mana: " + this.mana + ")");
        } else {
            super.atacar(alvo);
        }
    }

    public void curarAliado(Personagem aliado) {
        if (this.mana >= 15) {
            this.mana -= 15;
            aliado.curar(25);
            System.out.println(getNome() + " cura " + aliado.getNome() + ". " + aliado.status() + " (mana: " + this.mana + ")");
        } else {
            System.out.println(getNome() + " não tem mana para curar.");
        }
    }
}

class Arqueiro extends Personagem {
    private int qtdf;

    public Arqueiro(String nome, int vidam, int ataque, int defesa, int f) {
        super(nome, vidam, ataque, defesa);
        this.qtdf = f;
    }

    public int getFlechas() {
        return this.qtdf;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (this.qtdf > 0) {
            this.qtdf--;
            int força = getAtaque() + 5;
            int danor = alvo.receberDano(força);
            System.out.println(getNome() + " dispara uma flecha em " + alvo.getNome() + " e causa " + danor + " de dano. (flechas: " + this.qtdf + ")");
        } else {
            int força = getAtaque() / 2;
            int danor = alvo.receberDano(força);
            System.out.println(getNome() + " está sem flechas e dá um soco em " + alvo.getNome() + ": " + danor + " de dano.");
        }
    }

    public void recarregar() {
        this.qtdf += 3;
        System.out.println(getNome() + " recolhe flechas do chão. (flechas: " + this.qtdf + ")");
    }
}
    

