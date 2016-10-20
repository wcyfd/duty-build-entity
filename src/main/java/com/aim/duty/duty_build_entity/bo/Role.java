package com.aim.duty.duty_build_entity.bo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.aim.duty.duty_base.entity.base.AbstractProp;
import com.aim.duty.duty_base.entity.bo.BaseRole;
import com.aim.duty.duty_build_entity.po.Room;

public class Role extends BaseRole {
	private Wall wall;

	private int propUniqueId;

	private Room room;

	private Trade trade;

	private Map<Integer, AbstractProp> propMap = new HashMap<>();

	private Lock lock = new ReentrantLock();

	public void setWall(Wall wall) {
		this.wall = wall;
	}

	public Wall getWall() {
		return wall;
	}

	@Override
	public void setChange(boolean change) {
		// TODO Auto-generated method stub
		super.setChange(change);
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getPropUniqueId() {
		lock.lock();
		propUniqueId++;
		lock.unlock();
		return propUniqueId;
	}

	public Map<Integer, AbstractProp> getPropMap() {
		return propMap;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

}
