package co.simplon.poo.ch9.tp1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@ Data
@AllArgsConstructor

public abstract class Person {

	private String name;
	private String surname;
	private String job;
	private int yearOfExperience;
	private List<Project> projects;
	
	
}
