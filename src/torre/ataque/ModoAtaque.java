package torre.ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public interface ModoAtaque {
    public Bloon ataca(List<Bloon> bloons, Point centroTorre);
}
