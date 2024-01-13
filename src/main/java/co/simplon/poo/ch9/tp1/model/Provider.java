package co.simplon.poo.ch9.tp1.model;

import java.util.List;

public class Provider extends Person {

	private float averageDailyRate;

	public Provider(String name, String surname, String job, int yearOfExperience, List<Project> projects, float averageDailyRate) {
		super(name, surname, job, yearOfExperience, projects);
		this.setAverageDailyRate(averageDailyRate);
	}

	public void changeStateOfTask(Task task, State newState) {
		task.setState(newState); // Utilisation du setter pour changer l'état de la tâche
	}

	// Calcul de la rémunération pour le prestataire en fonction du temps passé sur une tâche
	public double calculateTheRemunerationForTask(Task task, float dailyRate) {
		int daysWorked = task.getTimeSpentInDay(); // Obtention du temps passé sur la tâche
		return daysWorked * dailyRate;
	}

	public float getAverageDailyRate() {
		return averageDailyRate;
	}

	public void setAverageDailyRate(float averageDailyRate) {
		this.averageDailyRate = averageDailyRate;
	}

}
