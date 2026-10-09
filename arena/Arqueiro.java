package arena;

public class Arqueiro extends Personagem {
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
