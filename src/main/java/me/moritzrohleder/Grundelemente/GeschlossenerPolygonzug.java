package me.moritzrohleder.Grundelemente;

public class GeschlossenerPolygonzug extends Polygonzug{

	public GeschlossenerPolygonzug(Punkt2D[] punkte) {
		super(punkte);
	}

	public GeschlossenerPolygonzug(double[] x, double[] y) {
		super(x, y);
	}

	@Override
	public Strecke2D[] getStrecken() {
		Strecke2D[] strecken = new Strecke2D[punkte.length];
		for(int i = 0; i < punkte.length - 1; i++) {
			strecken[i] = new Strecke2D(punkte[i], punkte[i + 1]);
		}
		strecken[punkte.length - 1] = new Strecke2D(punkte[punkte.length - 1], punkte[0]);
		return strecken;
	}
}
