package co.simplon.poo.ch9.tp1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.poo.ch9.tp1.model.Project;
import co.simplon.poo.ch9.tp1.model.Provider;
import co.simplon.poo.ch9.tp1.model.State;
import co.simplon.poo.ch9.tp1.model.Task;

public class TestProvider {
	
	@Test
	public void testChangeStateOfTask() {
		// Création d'une tâche pour le test
		Task task = new Task();
		task.setState(State.TO_DO);
		
		// Création d'un prestataire pour le test
		Provider provider = new Provider("Toto", "Tartampion", "Developer", 5, new ArrayList<>(), 500.0f);
		
		// Changement de l'état de la tâche par le prestataire
		provider.changeStateOfTask(task, State.IN_PROGRESS);

	
		// Vérification si l'état de la tâche a été modifié correctement
		assertEquals(State.IN_PROGRESS, task.getState());
	}
	
	@Test
	public void testCalculateRemuneration() {
		// Création d'une tâche avec 7 jours travaillés
	    Task task = new Task();
	    task.setTimeSpentInDay(7);

	    // Création d'un prestataire pour le test
	    Provider provider = new Provider("Tata", "Tsouintsouin", "Designer", 7, new ArrayList<>(), 750.0f);

	    // Calcul de la rémunération pour le prestataire en fonction du temps passé sur la tâche
	    double remuneration = provider.calculateTheRemunerationForTask(task, provider.getAverageDailyRate());

	    // Vérification si la rémunération est correcte (750 * 7 = 5250)
	    assertEquals(5250.0, remuneration);
	}
}
