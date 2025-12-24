package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;
import java.awt.Point;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class ComArmadura extends BloonCaracteristicasExtras implements Protecao{

    private BloonComArmadura BloonComArmadura;
    private int durabilidade;
    private ComponenteVisual imgProtecao;

    protected ComArmadura(BloonComArmadura BloonComArmadura, Bloon bloon, ComponenteVisual imgProtecao, int durabilidade){
        super(bloon);
        this.BloonComArmadura = BloonComArmadura;
        this.imgProtecao = imgProtecao;
        this.durabilidade = durabilidade;
    }

    @Override
    public int pop(int estrago) {
        durabilidade --;
        if(!temProtecao()){
            BloonComArmadura.tiraArmadura();
            return super.pop(estrago);
        }
        return 0;
   }

    @Override
    public void explode(int estrago) {
        super.explode(estrago);
    }

    @Override
    public boolean temProtecao() {
        return durabilidade > 0;
    }

    @Override
    public void desenhar(Graphics2D g) {
        super.desenhar(g);
        int pos = super.getPosicaoNoCaminho();
        Point p = super.getCaminho().getPoint(pos);
        imgProtecao.setPosicao(p);
        imgProtecao.desenhar(g);
    }
    
}
