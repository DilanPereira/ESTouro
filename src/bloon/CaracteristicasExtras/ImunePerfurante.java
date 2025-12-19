package bloon.CaracteristicasExtras;

import bloon.Bloon;

public class ImunePerfurante extends BloonCaracteristicasExtras {

    public ImunePerfurante(Bloon bloon) {
        super(bloon);
    }

    @Override
    public int pop(int estrago) {
        // Se é imune, o dano é 0;
        return 0;
    }

}
