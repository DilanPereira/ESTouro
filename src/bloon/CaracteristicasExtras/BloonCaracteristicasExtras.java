package bloon.CaracteristicasExtras;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import bloon.Bloon;
import bloon.BloonObserver;
import mundo.Caminho;
import mundo.Mundo;
import prof.jogos2D.image.ComponenteVisual;

public class BloonCaracteristicasExtras implements Bloon{

    private final Bloon bloon;

    public void desenhar(Graphics2D g) {
        bloon.desenhar(g);
    }

    public void mover() {
        bloon.mover();
    }

    public ComponenteVisual getComponente() {
        return bloon.getComponente();
    }

    public ComponenteVisual getPopComponente() {
        return bloon.getPopComponente();
    }

    public void setCaminho(Caminho rua) {
        bloon.setCaminho(rua);
    }

    public Caminho getCaminho() {
        return bloon.getCaminho();
    }

    public int getPosicaoNoCaminho() {
        return bloon.getPosicaoNoCaminho();
    }

    public void setPosicaoNoCaminho(int pos) {
        bloon.setPosicaoNoCaminho(pos);
    }

    public void setVelocidade(float veloc) {
        bloon.setVelocidade(veloc);
    }

    public float getVelocidade() {
        return bloon.getVelocidade();
    }

    public void setMundo(Mundo w) {
        bloon.setMundo(w);
    }

    public Mundo getMundo() {
        return bloon.getMundo();
    }

    public void setPosicao(Point p) {
        bloon.setPosicao(p);
    }

    public Rectangle getBounds() {
        return bloon.getBounds();
    }

    public int pop(int estrago) {
        return bloon.pop(estrago);
    }

    public void explode(int estrago) {
        bloon.explode(estrago);
    }

    public int getResistencia() {
        return bloon.getResistencia();
    }

    public int getValor() {
        return bloon.getValor();
    }

    public void setValor(int val) {
        bloon.setValor(val);
    }

    public void addBloonObserver(BloonObserver bo) {
        bloon.addBloonObserver(bo);
    }

    public void removeBloonObserver(BloonObserver bo) {
        bloon.removeBloonObserver(bo);
    }

    protected BloonCaracteristicasExtras(Bloon bloon){
        this.bloon = bloon;
    }

    protected Bloon getBloon() {
        return bloon;
    }

    public Bloon clone() {
        return bloon.clone();
    }


}
