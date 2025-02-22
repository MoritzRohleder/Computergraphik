package me.moritzrohleder.Grundelemente;

public class Polygon {
	private GeschlossenerPolygonzug polygonzug;

	public Polygon(GeschlossenerPolygonzug polygonzug) {
		this.polygonzug = polygonzug;
	}

	/**
	 * Checks if a given point lies inside the polygon.
	 * @param p the point to check
	 * @return the number of how often the polygon crosses the line from the point to the right
	 */
	public int punktInPolygon (Punkt2D p) {
		int nc = 0;
		int vz = polygonzug.punkte[0].getY() < p.getY() ? -1 : 1;

		for(int i = 1; i <= polygonzug.punkte.length; i++) {
			int j = (i % polygonzug.punkte.length) +1;

			int nvz = polygonzug.punkte[j].getY() < p.getY() ? -1 : 1;

			if(vz != nvz) {
				if(polygonzug.punkte[i].getX() >= p.getX() && polygonzug.punkte[j].getX() >= p.getX()) {
					nc++;
				} else if(polygonzug.punkte[i].getX() >= p.getX() || polygonzug.punkte[j].getX() >= p.getX()) {
					double xS =
							polygonzug.punkte[i].getX() + (p.getY() - polygonzug.punkte[i].getY())
									/ (polygonzug.punkte[j].getY() - polygonzug.punkte[i].getY())
									* (polygonzug.punkte[j].getX()-polygonzug.punkte[i].getX());
					if(xS >= p.getX()) {
						nc++;
					}
				}
			}
			vz = nvz;
		}
		return nc;
	}

	/**
	 * Returns the bounding box of the polygon.
	 * @return the bounding box of the polygon as an AchsenparallelesRechteck
	 */
	public AchsenparallelesRechteck getBoundingBoxAsRechteck() {
		Punkt2D[] boundingBox = getBoundingBox();
		return new AchsenparallelesRechteck(boundingBox[0], boundingBox[1]);
	}

	/**
	 * Returns the bounding box of the polygon.
	 * @return the bounding box of the polygon as an array of two points
	 */
	public Punkt2D[] getBoundingBox() {
		double minX = polygonzug.punkte[0].getX();
		double minY = polygonzug.punkte[0].getY();
		double maxX = polygonzug.punkte[0].getX();
		double maxY = polygonzug.punkte[0].getY();

		for(Punkt2D p : polygonzug.punkte) {
			minX = Math.min(minX, p.getX());
			minY = Math.min(minY, p.getY());
			maxX = Math.max(maxX, p.getX());
			maxY = Math.max(maxY, p.getY());
		}

		return new Punkt2D[] {new Punkt2D(minX, minY), new Punkt2D(maxX, maxY)};
	}
}
