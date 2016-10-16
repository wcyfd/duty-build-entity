package com.aim.duty.duty_build_entity.bo;

import java.util.Map;
import java.util.TreeMap;

import com.aim.duty.duty_base.entity.base.GameEntity;
import com.aim.duty.duty_base.service.prop.PropConstant;

public class Wall extends GameEntity {

	@Override
	public boolean isChange() {
		// TODO Auto-generated method stub
		return false;
	}

	private Map<Integer, Brick> brickList = new TreeMap<>();
	private int capacity;
	private int blood;

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public Map<Integer, Brick> getBrickMap() {
		return brickList;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public Wall clone() throws CloneNotSupportedException {
		Wall wall = (Wall) super.clone();
		wall.brickList = new TreeMap<>();

		for (Map.Entry<Integer, Brick> entrySet : brickList.entrySet()) {
			int index = entrySet.getKey();
			Brick brick = entrySet.getValue().clone();
			wall.brickList.put(index, brick);
		}
		return wall;
	}

}
