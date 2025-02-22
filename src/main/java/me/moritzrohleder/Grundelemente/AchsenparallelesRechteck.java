package me.moritzrohleder.Grundelemente;

public class AchsenparallelesRechteck {
	private Punkt2D pMin;
	private Punkt2D pMax;

	public AchsenparallelesRechteck(Punkt2D pMin, Punkt2D pMax) {
		this.pMin = pMin;
		this.pMax = pMax;
	}

	public AchsenparallelesRechteck(double xMin, double yMin, double xMax, double yMax) {
		this(new Punkt2D(xMin, yMin), new Punkt2D(xMax, yMax));
	}

	/**
	 * Berechnet die Fläche des Rechtecks
	 * @return Fläche des Rechtecks
	 */
	public double berechneFlaeche() {
		double breite = pMax.getX() - pMin.getX();
		double hoehe = pMax.getY() - pMin.getY();
		return breite * hoehe;
	}

	/**
	 * Berechnet den Umfang des Rechtecks
	 * @return Umfang des Rechtecks
	 */
	public double berechneUmfang() {
		double breite = pMax.getX() - pMin.getX();
		double hoehe = pMax.getY() - pMin.getY();
		return 2 * (breite + hoehe);
	}

	/**
	 * Überprüft, ob ein Punkt innerhalb des Rechtecks liegt
	 * @param p Punkt, der überprüft werden soll
	 * @return true, wenn der Punkt innerhalb des Rechtecks liegt, sonst false
	 */
	public boolean PunktInRechteck(Punkt2D p){
		if(p.getX() >= pMin.getX() && p.getX() <= pMax.getX()) {
			if(p.getY() >= pMin.getY() && p.getY() <= pMax.getY()) {
				return true;
			}
		}
		return false;
	}

	public Punkt2D getpMin() {
		return pMin;
	}

	public Punkt2D getpMax() {
		return pMax;
	}
}
