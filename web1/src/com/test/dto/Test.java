package com.test.dto;

import java.util.ArrayList;

public class Test {
	
	private String name;
	private double num;
	private String command;
	private Struct struct;
	private ArrayList people;

	public ArrayList getPeople() {
		return people;
	}
	public void setPeople(ArrayList people) {
		this.people = people;
	}
	public Struct getStruct() {
		return struct;
	}
	public void setStruct(Struct struct) {
		this.struct = struct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", num=" + num + ", command=" + command + ", struct=" + struct + ", people="
				+ people + "]";
	}
	
}
