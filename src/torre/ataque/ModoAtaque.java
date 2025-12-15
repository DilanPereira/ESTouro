package torre.ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public interface ModoAtaque {
    ModoAtaque PRIMEIRO = new Ataca_Primeiro();
    ModoAtaque ULTIMO = new Ataca_Ultimo();
    ModoAtaque PERTO = new Ataca_Perto();
    ModoAtaque LONGE = new Ataca_Longe();
    ModoAtaque FORTE = new Ataca_Forte();
    ModoAtaque JUNTOS = new Ataca_Juntos();

    public Point ataca(List<Bloon> bloons, Point centroTorre);
}
