package torre;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.List;

import bloon.Bloon;
import prof.jogos2D.image.ComponenteMultiAnimado;
import prof.jogos2D.util.DetectorColisoes;
import torre.projetil.Projetil;

public class TorreSniper extends TorreDefault {

    private static final int estrago = 5;

    public TorreSniper(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(50, 50), img, 2, 4, 3), 30, 8, new Point(0, 0), 25);
	}

    @Override
    public void gravaTorre(PrintWriter pw) {
        pw.println("sniper");
    }

    @Override
    public Projetil[] atacar(List<Bloon> bloons) {
        atualizarCicloDisparo();

		// vamos buscar o desenho pois vai ser preciso várias vezes
		ComponenteMultiAnimado anim = getComponente();

		// já acabou a animação de disparar? volta à animação de pausa
		if (anim.getAnim() == ATAQUE_ANIM && anim.numCiclosFeitos() >= 1) {
			anim.setAnim(PAUSA_ANIM);
		}

		if (bloons.size() == 0)
			return new Projetil[0];
		// FEITO remover este switch e suportar os restantes modos de ataque
		// ver a posição do centro para o teste de estar perto
		Point centro = getComponente().getPosicaoCentro();
        // determinar o bloon alvo, consoante o método de ataque
		Bloon bloonAlvo = getModoAtaque().ataca(bloons, centro);
		
		if (bloonAlvo == null)
			return new Projetil[0];

		// ver o ângulo que o alvo faz com a torre, para assim rodar esta
		double angle1 = DetectorColisoes.getAngulo(bloonAlvo.getComponente().getPosicaoCentro(), anim.getPosicaoCentro());
		anim.setAngulo(angle1);

		// se vai disparar daqui a pouco, começamos já com a animação de ataque
		// para sincronizar a frame de disparo com o disparo real
		sincronizarFrameDisparo(anim);

		// se ainda não está na altura de disparar, não dispara
		if (!podeDisparar())
			return new Projetil[0];

		// disparar
		resetTempoDisparar();

        bloonAlvo.pop(estrago);

		return null;
	}

}
