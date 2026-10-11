// Autor: Francisco israel de almeida costa (2026003459)
package arena;

    public class Guerreiro extends Personagem {
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

