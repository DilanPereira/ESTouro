package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;
import java.awt.Point;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class ComArmadura extends BloonCaracteristicasExtras implements Protecao{

    private final BloonComArmadura bloonControlador;
    private int durabilidadeAtual;

    protected ComArmadura(BloonComArmadura BloonComArmadura, Bloon bloon){
        super(bloon);
        this.bloonControlador = BloonComArmadura;
        this.durabilidadeAtual = BloonComArmadura.getDurabilidade();
    }

    @Override
    public int pop(int estrago) {
        durabilidadeAtual --;
        if(!temProtecao()){
            bloonControlador.tiraArmadura();
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
        return durabilidadeAtual > 0;
    }

    @Override
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
        return new ComArmadura(this.bloonControlador, getBloon().clone());
    }
}
