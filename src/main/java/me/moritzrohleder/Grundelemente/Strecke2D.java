package me.moritzrohleder.Grundelemente;

public class Strecke2D {
	private Punkt2D p1;
	private Punkt2D p2;

	public Strecke2D(Punkt2D p1, Punkt2D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Calculates the length of the line segment defined by this object.
	 *
	 * @return the length of the line segment
	 */
	public double laenge() {
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}

	/**
	 * Checks if a given point lies on the line segment defined by this object.
	 *
	 * @param p the point to check
	 * @return true if the point lies on the line segment, false otherwise
	 */
	public boolean punktAufStrecke(Punkt2D p) {
		double m = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		double n = p1.getY() - m * p1.getX();

		return p.getY() == m * p.getX() + n;
	}
}
