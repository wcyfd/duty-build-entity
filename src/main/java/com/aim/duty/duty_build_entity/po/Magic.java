package com.aim.duty.duty_build_entity.po;

import com.aim.duty.duty_base.entity.base.GameObject;
import com.aim.duty.duty_base.entity.protobuf.serial.Serial;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

public class Magic extends GameObject {
	/** 魔法id */
	private int magicId;
	/** 有效时间 */
	private int duration;
	/** 增加值 */
	private int value;

	public int getMagicId() {
		return magicId;
	}

	public void setMagicId(int id) {
		this.magicId = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Magic clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Magic) super.clone();
	}

//	@Override
//	public void deserialize(ByteString data) {
//		try {
//			Serial.Magic ser = Serial.Magic.parseFrom(data);
//			this.setDuration(ser.getDuration());
//			this.setMagicId(ser.getMagicId());
//			this.setValue(ser.getValue());
//			super.deserialize(ser.getSuperClassData());
//		} catch (InvalidProtocolBufferException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public ByteString serialize() {
//		// TODO Auto-generated method stub
//		ByteString data = Serial.Magic.newBuilder().setDuration(duration).setMagicId(magicId).setValue(value)
//				.setSuperClassData(super.serialize()).build().toByteString();
//		return data;
//	}

}
