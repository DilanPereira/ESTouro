package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;

import bloon.Bloon;
import bloon.CaracteristicasExtras.BloonCaracteristicasExtras;
import prof.jogos2D.image.ComponenteVisual;

public class BloonComEscudo extends BloonCaracteristicasExtras implements Protecao{
    private Protecao comEscudo;
    private Protecao semProtecao;

    private Protecao estadoArmadura;

    private ComponenteVisual img;
    private int durabilidade;

    public BloonComEscudo(Bloon bloon, ComponenteVisual img, int durabilidade){
        super(bloon);
        this.img = img;
        this.durabilidade = durabilidade;
        this.comEscudo = new ComEscudo(this, bloon);
        this.semProtecao = new SemProtecao(bloon);

        this.estadoArmadura = this.comEscudo;
    }

    public ComponenteVisual getImagem(){
        return img;
    }
    public int getDurabilidade(){
        return durabilidade;
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

    @Override
    public Bloon clone() {
        return new BloonComEscudo(getBloon().clone(), this.img, this.durabilidade);
    }

}
