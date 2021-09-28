package com.practice.classes;

public class Point {
	private int x;
	private int y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distance() {
		return this.distance(0, 0);
	}

	public double distance(Point p) {
		return this.distance(p.getX(), p.getY());
	}

	public double distance(int x, int y) {
		return Math.sqrt(Math.pow((this.getX() - x), 2) + Math.pow((this.getY() - y), 2));
	}

}
