package me.moritzrohleder.Grundelemente;

public class Polygonzug {
	protected Punkt2D[] punkte;

	public Polygonzug(Punkt2D[] punkte) {
		this.punkte = punkte;
	}

	public Polygonzug(double[] x, double[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("x and y must have the same length");
		}
		punkte = new Punkt2D[x.length];
		for (int i = 0; i < x.length; i++) {
			punkte[i] = new Punkt2D(x[i], y[i]);
		}
	}

	/**
	 * Returns an array of Strecke2D objects that represent the segments of the polygonzug.
	 * @return an array of Strecke2D objects that represent the segments of the polygonzug.
	 */
	public Strecke2D[] getStrecken() {
		Strecke2D[] strecken = new Strecke2D[punkte.length - 1];
		for(int i = 0; i < punkte.length - 1; i++) {
			strecken[i] = new Strecke2D(punkte[i], punkte[i + 1]);
		}
		return strecken;
	}

	/**
	 * Returns the total length of the polygonzug.
	 * @return the total length of the polygonzug.
	 */
	public double laenge() {
		double laenge = 0;
		for (Strecke2D strecke : getStrecken()) {
			laenge += strecke.laenge();
		}
		return laenge;
	}

	/**
	 * Checks if a given point lies on the polygonzug.
	 * @param p the point to check
	 * @return true if the point lies on the polygonzug, false otherwise
	 */
	public boolean punktAufPolygonzug(Punkt2D p) {
		for (Strecke2D strecke : getStrecken()) {
			if (strecke.punktAufStrecke(p)) {
				return true;
			}
		}
		return false;
	}
}
