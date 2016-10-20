package com.aim.duty.duty_build_entity.bo;

import java.util.HashMap;
import java.util.Map;

import com.aim.duty.duty_base.entity.base.AbstractProp;
import com.aim.duty.duty_base.entity.base.CustomSerializable;
import com.aim.duty.duty_base.service.prop.PropConstant;
import com.aim.duty.duty_build_entity.fo.OreConfig;
import com.aim.duty.duty_build_entity.po.Magic;
import com.aim.duty.duty_build_entity.protobuf.serial.SerialBuild.SerBrick;
import com.aim.duty.duty_build_entity.protobuf.serial.SerialBuild.SerMagic;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

public class Brick extends AbstractProp implements CustomSerializable<Brick> {
	private int mineId;
	
	private int position;

	private Map<Integer, Magic> magicMap = new HashMap<>();

	public Map<Integer, Magic> getMagicMap() {
		return magicMap;
	}

	public int getMineId() {
		return mineId;
	}

	public void setMineId(int mineId) {
		this.mineId = mineId;
	}

	@Override
	public boolean isChange() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int getInitPropType() {
		// TODO Auto-generated method stub
		return PropConstant.BRICK;
	}

	@Override
	public Brick clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Brick b = (Brick) super.clone();
		b.magicMap = new HashMap<>();
		for (Map.Entry<Integer, Magic> entrySet : this.magicMap.entrySet()) {
			int magicId = entrySet.getKey();
			Magic magic = entrySet.getValue().clone();
			b.magicMap.put(magicId, magic);
		}
		return b;
	}

	@Override
	public ByteString serialize() {
		// TODO Auto-generated method stub
		SerBrick.Builder brickBuilder = SerBrick.newBuilder();
		brickBuilder.setMineId(this.mineId);
		Map<Integer, SerMagic> serMagicMap = new HashMap<>();
		for (Magic magic : this.magicMap.values()) {
			serMagicMap.put(magic.getMagicId(), SerMagic.newBuilder().setDuration(magic.getDuration())
					.setMagicId(magic.getMagicId()).setValue(magic.getValue()).build());
		}
		brickBuilder.putAllMagics(serMagicMap);
		return brickBuilder.build().toByteString();
	}

	@Override
	public Brick deserialize(ByteString data) {
		// TODO Auto-generated method stub

		try {
			SerBrick serBrick = SerBrick.parseFrom(data);
			this.mineId = serBrick.getMineId();
			Map<Integer, SerMagic> serMagicMap = serBrick.getMagicsMap();

			this.magicMap.clear();
			for (SerMagic serMagic : serMagicMap.values()) {
				Magic magic = new Magic();
				magic.setDuration(serMagic.getDuration());
				magic.setMagicId(serMagic.getMagicId());
				magic.setValue(serMagic.getValue());
				this.magicMap.put(magic.getMagicId(), magic);
			}

			return this;

		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
