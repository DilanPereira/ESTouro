package torre;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.List;

import bloon.Bloon;
import game.manipulator.ManipuladorOcto;
import game.manipulator.ManipuladorTorre;
import prof.jogos2D.image.*;
import prof.jogos2D.util.ImageLoader;
import torre.projetil.Dardo;
import torre.projetil.Projetil;

/**
 * Classe que representa a torre octogonal. Esta torre dispara 8 dardos, um em
 * cada direção dos seus lançadores. Só dispara quando tem bloons dentro do seu
 * raio de ação.
 */
public class TorreOctogonal extends TorreDefault {

	private double baseAngle = 0;

	public TorreOctogonal(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(), img, 2, 4, 2),
				20, 6, new Point(0, 0), 100);
	}

	/**
	 * Altera o ângulo da octo
	 * 
	 * @param angle o novo ângulo
	 */
	public void setAngle(double angle) {
		getComponente().setAngulo(angle);
		baseAngle = angle;
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

	@Override
	protected double determinarAngulo(List<Bloon> bloons, ComponenteMultiAnimado anim){
		return (double) 0;
	}

	protected Projetil[] criarProjetil(Double angle, Point shoot){
		Projetil p[] = new Projetil[8];
		double angulo = baseAngle + Math.PI / 2;
		double incAng = Math.PI / 4;
		for (int i = 0; i < 8; i++) {
			ComponenteVisual img = new ComponenteAnimado(new Point(),
					(BufferedImage) ImageLoader.getLoader().getImage("data/torres/dardo.gif"), 2, 2);
			p[i] = new Dardo(img, angulo, 8, 1);
			p[i].setPosicao(shoot);
			p[i].setAlcance(getRaioAcao() + 15);
			angulo -= incAng;
		}
		return p;
	}


	@Override
	public ManipuladorTorre criarManipulador(){
		return new ManipuladorOcto(this);
	}

	@Override
	public void gravaTorre(PrintWriter pw){
		pw.print("octo\t");
		pw.println(this.getComponente().getAngulo());
	}
}
