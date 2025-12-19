package bloon.CaracteristicasExtras;

import java.awt.Graphics2D;

public interface EstadoArmadura {
    int pop(int estrago);
    void explode(int estrago);
    void desenhar(Graphics2D g);
}
