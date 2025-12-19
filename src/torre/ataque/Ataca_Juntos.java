package torre.ataque;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bloon.Bloon;

public class Ataca_Juntos implements ModoAtaque {
    public Bloon ataca(List<Bloon> bloons, Point centroTorre) {
        Map<Integer, List<Bloon>> posicoes = bloons.stream().collect(Collectors.groupingBy(b -> b.getPosicaoNoCaminho() / 20));
		int posicaoComMais = Collections.max(posicoes.keySet(),(k1, k2) -> posicoes.get(k1).size() - posicoes.get(k2).size());
		Bloon bj = posicoes.get(posicaoComMais).getFirst();
		return bj;
    }
}
