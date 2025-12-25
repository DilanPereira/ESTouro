package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;
import java.awt.Point;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class ComEscudo extends BloonCaracteristicasExtras implements Protecao{
    
    private final BloonComEscudo bloonControlador;
    private int durabilidadeAtual;

    protected ComEscudo(BloonComEscudo BloonComEscudo, Bloon bloon){
        super(bloon);
        this.bloonControlador = BloonComEscudo;
        this.durabilidadeAtual = BloonComEscudo.getDurabilidade();
    }

    @Override
    public int pop(int estrago) {
        return super.pop(estrago);
   }

    @Override
    public void explode(int estrago) {
        durabilidadeAtual --;
        if(!temProtecao()){
            bloonControlador.tiraArmadura();
            super.explode(estrago);
        }
    }

    @Override
    public boolean temProtecao() {
        return durabilidadeAtual > 0;
    }

    public void desenhar(Graphics2D g) {
        super.desenhar(g);
        int pos = super.getPosicaoNoCaminho();
        Point p = super.getCaminho().getPoint(pos);
        ComponenteVisual img = bloonControlador.getImagem();
        img.setPosicao(p);
        img.desenhar(g);
    }

    @Override
    public Bloon clone() {
        return new ComEscudo(this.bloonControlador, getBloon().clone());
    }
}
