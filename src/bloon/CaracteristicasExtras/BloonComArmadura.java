package bloon.CaracteristicasExtras;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Objects;

import prof.jogos2D.image.ComponenteVisual;

public class BloonComArmadura implements EstadoArmadura {

    private Armadura armadura;
    private int armaduraValor;
    private ComponenteVisual imgArmadura;

    protected BloonComArmadura(Armadura armadura, int armaduraValor, ComponenteVisual imgArmadura) {
        this.armadura = Objects.requireNonNull(armadura);
        if(armaduraValor <= 0) {
            throw new IllegalArgumentException("Valor da armadura deve ser maior que zero.");
        }
        this.armaduraValor = armaduraValor;
        this.imgArmadura = Objects.requireNonNull(imgArmadura);
    }

    @Override
    public int pop(int estrago) {
        armaduraValor --;
        verificaArmadura();
        return 0;
    }

    @Override
    public void explode(int estrago) {
        armaduraValor --;
        verificaArmadura();
    }

    @Override
    public void desenhar(Graphics2D g) {
        int pos = armadura.getPosicaoNoCaminho();
        Point p = armadura.getCaminho().getPoint(pos);
        imgArmadura.setPosicao(p);
        imgArmadura.desenhar(g);
        
    }


    private void verificaArmadura() {
        if (armaduraValor <= 0) {
            armadura.perdeArmadura();
        }
    }
}
