package torre;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.List;

import bloon.Bloon;
import prof.jogos2D.image.*;
import prof.jogos2D.util.DetectorColisoes;
import prof.jogos2D.util.ImageLoader;
import torre.projetil.BombaImpacto;
import torre.projetil.Projetil;

/**
 * Classe que representa a torre canhão. Esta torre dispara uma bomba que
 * explode ao contato com os bloons. Só dispara quando tem bloons dentro do seu
 * raio de ação e atira para o bloon de acordo com o seu modo de ataque
 */
public class TorreCanhao extends TorreDefault {

	public TorreCanhao(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(50, 50), img, 2, 4, 2),
				30, 0, new Point(25, 0), 120);
	}

	//Metodos para o Ataque:
	protected Point determinaAlvo(List<Bloon> bloons){
		// ver quais os bloons que estão ao alcance
		List<Bloon> alvosPossiveis = getBloonsInRadius(bloons, getComponente().getPosicaoCentro(), getRaioAcao());
		if (alvosPossiveis.size() == 0)
			return null;
		// FEITO remover este switch e suportar os restantes modos de ataque
		// ver a posição do centro para o teste de estar perto
		Point centro = getComponente().getPosicaoCentro();
		return getModoAtaque().ataca(alvosPossiveis, centro);
	}

	protected double determinarAngulo(List<Bloon> bloons, ComponenteMultiAnimado anim){
		Point posAlvo = determinaAlvo(bloons);
		//Não precisa de verificação, porque está feita na superclasse

		// ver o ângulo que o alvo faz com a torre, para assim rodar esta
		double angle1 = DetectorColisoes.getAngulo(posAlvo, anim.getPosicaoCentro());
		anim.setAngulo(angle1);

		// ajustar o ângulo
		return angle1;
	}

	protected Projetil[] criarProjetil(Double angle, Point shoot){
		Projetil p[] = new Projetil[1];
		ComponenteVisual img = new ComponenteSimples(ImageLoader.getLoader().getImage("data/torres/bomba.gif"));
		p[0] = new BombaImpacto(img, angle, 12, 2, getMundo());
		p[0].setPosicao(shoot);
		p[0].setAlcance(getRaioAcao() + 20);
		return p;
	}


	@Override
	public void gravaTorre(PrintWriter pw){
		pw.println("canhao");
	}
}
