package torre.ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class Ataca_Ultimo implements ModoAtaque {
    public Point ataca(List<Bloon> bloons, Point centroTorre) {
        Bloon bu = bloons.stream().min((b1, b2) -> b1.getPosicaoNoCaminho() - b2.getPosicaoNoCaminho()).get();
		return bu.getComponente().getPosicaoCentro();
    }
}
