package me.moritzrohleder.Grundelemente;

public class Punkt2D {
	private double x;
	private double y;

	public Punkt2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Punkt2D p){
		return this.x == p.getX() && this.y == p.getY();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
