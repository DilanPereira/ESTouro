package bloon.CaracteristicasExtras;

import bloon.Bloon;

public class ImuneExplosao extends BloonCaracteristicasExtras {

    public ImuneExplosao(Bloon bloon) {
        super(bloon);
    }

    @Override
    public void explode(int estrago) {
        // Se é imune, não faz nada
    }

    @Override
    public Bloon clone() {
        return new ImuneExplosao(this);
    }
}
