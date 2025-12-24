package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class BloonComArmadura extends BloonCaracteristicasExtras implements Protecao{
    private Protecao comArmadura;
    private Protecao semProtecao;

    private Protecao estadoArmadura;

    public BloonComArmadura(Bloon bloon, ComponenteVisual img, int durabilidade){
        super(bloon);
        this.comArmadura = new ComArmadura(this, bloon, img, durabilidade);
        this.semProtecao = new SemProtecao(bloon);

        this.estadoArmadura = this.comArmadura;
    }

    public void tiraArmadura(){
        this.estadoArmadura = this.semProtecao;
    }

    @Override
    public int pop(int estrago) {
        return estadoArmadura.pop(estrago);
    }

    @Override
    public void explode(int estrago) {
        estadoArmadura.explode(estrago);
    }

    @Override
    public boolean temProtecao() {
        return estadoArmadura.temProtecao();
    }

    @Override
    public void desenhar(Graphics2D g) {
        estadoArmadura.desenhar(g);
    }

    

}
