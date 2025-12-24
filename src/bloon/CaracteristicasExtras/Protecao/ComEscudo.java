package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;
import java.awt.Point;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class ComEscudo extends BloonCaracteristicasExtras implements Protecao{
    
    private int durabilidade;
    private ComponenteVisual imgProtecao;
    private BloonComEscudo BloonComEscudo;

    protected ComEscudo(BloonComEscudo BloonComEscudo, Bloon bloon, ComponenteVisual imgProtecao, int durabilidade){
        super(bloon);
        this.BloonComEscudo = BloonComEscudo;
        this.imgProtecao = imgProtecao;
        this.durabilidade = durabilidade;
    }

    @Override
    public int pop(int estrago) {
        return super.pop(estrago);
   }

    @Override
    public void explode(int estrago) {
        durabilidade --;
        if(!temProtecao()){
            BloonComEscudo.tiraArmadura();
            super.explode(estrago);
        }
    }

    @Override
    public boolean temProtecao() {
        return durabilidade > 0;
    }

    public void desenhar(Graphics2D g) {
        super.desenhar(g);
        int pos = super.getPosicaoNoCaminho();
        Point p = super.getCaminho().getPoint(pos);
        imgProtecao.setPosicao(p);
        imgProtecao.desenhar(g);
    }
}
