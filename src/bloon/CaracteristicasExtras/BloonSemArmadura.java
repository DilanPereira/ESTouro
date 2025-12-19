package bloon.CaracteristicasExtras;

import java.awt.Graphics2D;
import java.util.Objects;

public class BloonSemArmadura implements EstadoArmadura {
    private Armadura armadura;

    protected BloonSemArmadura(Armadura armadura) {
        this.armadura = Objects.requireNonNull(armadura);
    }

    @Override
    public int pop(int estrago) {
        return armadura.getBloon().pop(estrago);
    }

    @Override
    public void explode(int estrago) {
        armadura.getBloon().explode(estrago);
    }

    @Override
    public void desenhar(Graphics2D g) {
        // Não desenha nada, pois não há armadura
    }
}