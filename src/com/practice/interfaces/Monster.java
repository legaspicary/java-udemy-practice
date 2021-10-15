package com.practice.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
	private String name;
	private int hitPoints;
	private int strength;

	public Monster(String name, int hitPoints, int strength) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
	}

	public String getName() {
		return name;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	@Override
	public List<String> write() {
		ArrayList<String> fields = new ArrayList<String>();
		fields.add(this.getName());
		fields.add(this.getHitPoints() + "");
		fields.add(this.getStrength() + "");
		return fields;
	}

	@Override
	public void read(List<String> fields) {
		if (fields != null && fields.size() > 0) {
			this.name = fields.get(0);
			this.hitPoints = Integer.parseInt(fields.get(1));
			this.strength = Integer.parseInt(fields.get(2));
		}
	}

	@Override
	public String toString() {
		return String.format("Monster{name='%s', hitPoints=%d, strength=%d}", this.getName(), this.getHitPoints(),
				this.getStrength());
	}
}
