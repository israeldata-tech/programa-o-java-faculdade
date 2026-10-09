package arena;

    public class Personagem {
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

