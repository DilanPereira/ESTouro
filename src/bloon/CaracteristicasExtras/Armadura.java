package bloon.CaracteristicasExtras;

import java.awt.Graphics2D;
import java.util.Objects;

import bloon.Bloon;
import prof.jogos2D.image.ComponenteVisual;

public class Armadura extends BloonCaracteristicasExtras implements EstadoArmadura {
    private EstadoArmadura estado;

    public Armadura(Bloon bloon, int armadura, ComponenteVisual imgArmadura) {
        super(Objects.requireNonNull(bloon));
        if(armadura <= 0) {
            throw new IllegalArgumentException("Valor da armadura deve ser maior que zero.");
        }
        this.estado = new BloonComArmadura(this, armadura, Objects.requireNonNull(imgArmadura));
    }

    @Override
    public void desenhar(Graphics2D g) {
        super.desenhar(g);
        estado.desenhar(g);
    }

    @Override
    public int pop(int estrago) {
        return estado.pop(estrago);
    }

    @Override
    public void explode(int estrago) {
        estado.explode(estrago);
    }

    protected void perdeArmadura() {
        this.estado = new BloonSemArmadura(this);
    }

    protected Bloon getBloon() {
        return super.getBloon();
    }
    
}
