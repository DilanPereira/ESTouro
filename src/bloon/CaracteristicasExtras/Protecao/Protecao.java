package bloon.CaracteristicasExtras.Protecao;

import java.awt.Graphics2D;

import bloon.Bloon;

public interface Protecao {
    public int pop(int estrago);
    public void explode(int estrago);
    public boolean temProtecao();
    public void desenhar(Graphics2D g);
    public Bloon clone();
}