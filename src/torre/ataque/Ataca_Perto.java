package torre.ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class Ataca_Perto implements ModoAtaque {
    public Point ataca(List<Bloon> bloons, Point centroTorre) {
        return bloons.stream().min(
                        (b1, b2) -> Double.compare(
                                b1.getComponente().getPosicaoCentro().distance(centroTorre),
                                b2.getComponente().getPosicaoCentro().distance(centroTorre)
                        )
                ).map(b -> b.getComponente().getPosicaoCentro()).orElse(null);
    }

}
