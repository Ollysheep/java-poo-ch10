package co.simplon.poo.ch9.tp1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@ Getter
@ Setter

public class Project {
	LocalDate startDate;
	LocalDate endDate;
	boolean state;
	List<Task> listOfTask;

	public Project(LocalDate startDate, LocalDate endDate, boolean state) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.listOfTask = new ArrayList<>();
	}


}

