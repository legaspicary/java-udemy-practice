package com.practice.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
	private String name;
	private String weapon;
	private int hitPoints;
	private int strength;

	public Player(String name, int hitPoints, int strength) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.weapon = "Sword";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public List<String> write() {
		ArrayList<String> fields = new ArrayList<String>();
		fields.add(this.getName());
		fields.add(this.getHitPoints() + "");
		fields.add(this.getStrength() + "");
		fields.add(this.getWeapon());
		return fields;
	}

	@Override
	public void read(List<String> fields) {
		if (fields != null && fields.size() > 0) {
			this.setName(fields.get(0));
			this.setHitPoints(Integer.parseInt(fields.get(1)));
			this.setStrength(Integer.parseInt(fields.get(2)));
			this.setWeapon(fields.get(3));
		}
	}

	@Override
	public String toString() {
		return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}", this.getName(),
				this.getHitPoints(), this.getStrength(), this.getWeapon());
	}

}
