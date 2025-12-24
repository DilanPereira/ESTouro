package bloon.CaracteristicasExtras.Protecao;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;

public class SemProtecao extends BloonCaracteristicasExtras implements Protecao{

    protected SemProtecao(Bloon bloon){
        super(bloon);
    }

    @Override
    public boolean temProtecao() {
        return false;
    }

}
