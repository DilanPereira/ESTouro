package torre.ataque;

import bloon.Bloon;

import java.awt.Point;
import java.util.List;

public class Ataca_Longe implements ModoAtaque{
    public Bloon ataca(List<Bloon> bloons, Point centroTorre) {
        return bloons.stream().max(
                (b1, b2) -> Double.compare(
                        b1.getComponente().getPosicaoCentro().distance(centroTorre),
                        b2.getComponente().getPosicaoCentro().distance(centroTorre)
                )
        ).get();
    }
}
