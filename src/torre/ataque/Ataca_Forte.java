package torre.ataque;

import bloon.Bloon;

import java.awt.Point;
import java.util.List;

public class Ataca_Forte implements ModoAtaque{
    public Bloon ataca(List<Bloon> bloons, Point centroTorre) {
        Bloon bp = bloons.stream()
                      .max((b1, b2) -> b1.getValor() - b2.getValor())
                      .get();

        return bp;
    }

}
