package com.leon.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import ch.qos.logback.core.encoder.EncoderBase;

@Entity
public class Record {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, unique = true)
	private String recordName;
	@Column(nullable = false)
	private int year;
	@Lob
	@Column(nullable = false)
	private byte[] photo1;

	public long getId() {
		return id;
	}

	public Record setId(long id) {
		this.id = id;
		return this;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public byte[] getPhoto1() {
		return photo1;
	}

	public void setPhoto1(byte[] photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto1Display() {
		return Base64.getEncoder().encodeToString(getPhoto1());
	}
}
