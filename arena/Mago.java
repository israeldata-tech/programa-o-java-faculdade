package arena;

public class Mago extends Personagem {
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
