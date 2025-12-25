package torre;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.List;

import bloon.Bloon;
import game.manipulator.ManipuladorSniper;
import game.manipulator.ManipuladorTorre;
import prof.jogos2D.image.ComponenteAnimado;
import prof.jogos2D.image.ComponenteMultiAnimado;
import prof.jogos2D.image.ComponenteVisual;
import prof.jogos2D.util.ImageLoader;
import torre.projetil.Dardo;
import torre.projetil.Projetil;

public class TorreSniper extends TorreDefault {

    /** ponto para onde o sniper faz pontaria */
	private Point mira;
    private Point posBloon;

	/**
	 * Cria um sniper.
	 * 
	 * @param img imagem do sniper
	 */
	public TorreSniper(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(), img, 2, 4, 2),
				20, 0, new Point(0, 0), 999);
		setAnguloDisparo(0);
	}

	/**
	 * Define o ângulo de disparo do sniper
	 * 
	 * @param angulo o novo ângulo
	 */
	public void setAnguloDisparo(float angulo) {
		getComponente().setAngulo(angulo);
		definirMira(angulo);
	}

	/**
	 * Define a pontaria, isto é, a posição para onde o sniper irá apontar
	 * 
	 * @param angulo angulo do disparo, para poder calcular a área de ataque
	 */
	private void definirMira(double angulo) {
		double cos = Math.cos(angulo);
		double sin = Math.sin(angulo);
		Point centro = getComponente().getPosicaoCentro();
		mira = new Point((int) (centro.x + getRaioAcao() * cos), (int) (centro.y + getRaioAcao() * sin));
	}

	/**
	 * Retorna o ponto para onde o sniper irá disparar
	 * 
	 * @return o ponto para onde o sniper irá disparar
	 */
	public Point getMira() {
		return mira;
	}

	@Override
	public void setPosicao(Point p) {
		super.setPosicao(p);
		definirMira(getComponente().getAngulo());
	}

	@Override
	public void desenhaRaioAcao(Graphics2D g) {
		Point centro = getComponente().getPosicaoCentro();
		Point mira = getMira();
		Composite oldComp = g.getComposite();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g.setColor(Color.BLUE);
		Line2D.Float l = new Line2D.Float(centro, mira);
		g.setStroke(new BasicStroke(20));
		g.draw(l);
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(18));
		g.draw(l);
		g.setComposite(oldComp);
	}

	//Metodos de Ataque:
	protected Point determinaAlvo(List<Bloon> bloons){
		List<Bloon> alvosPossiveis = getBloonsInLine(bloons, getComponente().getPosicaoCentro(), getMira());
        if (alvosPossiveis.size() == 0)
            return null;
        this.posBloon = getModoAtaque().ataca(alvosPossiveis, mira);
		return mira;
	}

	protected double determinarAngulo(List<Bloon> bloons, ComponenteMultiAnimado anim){
		// ver o ângulo que o alvo faz com a torre, para assim rodar esta
		return anim.getAngulo();
	}

	protected Projetil[] criarProjetil(Double angle, Point shoot){
		Projetil p[] = new Projetil[1];
		ComponenteVisual img = new ComponenteAnimado(new Point(),
				(BufferedImage) ImageLoader.getLoader().getImage("data/torres/dardo.gif"), 2, 2);
		p[0] = new Dardo(img, angle, 10, 5);
		p[0].setPosicao(posBloon);
		p[0].setAlcance(getRaioAcao());
		return p;
	}

	@Override
	public Torre clone() {
		TorreSniper copia = (TorreSniper) super.clone();
		copia.mira = new Point(mira);
		return copia;
	}

	@Override
	public ManipuladorTorre criarManipulador(){
		return new ManipuladorSniper(this);
	}

	public void gravaTorre(PrintWriter pw){
		pw.print("sniper\t");
		pw.println(this.getComponente().getAngulo());
	}

	@Override
	public boolean temModosAtaque() {
		return true;
	}
}
