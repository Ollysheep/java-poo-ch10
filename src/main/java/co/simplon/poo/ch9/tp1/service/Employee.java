package co.simplon.poo.ch9.tp1.service;

import java.time.LocalDate;

import co.simplon.poo.ch9.tp1.model.Project;
import co.simplon.poo.ch9.tp1.model.Provider;
import co.simplon.poo.ch9.tp1.model.Task;

public interface Employee {

    // Méthode pour créer un projet
    public Project createProject(LocalDate startDate, LocalDate endDate, boolean state);

    // Méthode pour supprimer un projet
    public void deleteProject(Project project);

    // Méthode pour associer un prestataire à un projet
    public void associateProvider(Provider provider, Project project);

    // Méthode pour ajouter des tâches à un projet
    public void addTaskToProject(Task task, Project project);
}
