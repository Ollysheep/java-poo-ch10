package co.simplon.poo.ch9.tp1.model;

import lombok.Data;

@Data

public class Task {
	
	Task previousTask;
	Task nextTask;
    State state;
    int timeSpentInDay;
    String text;
    
    public void setTimeSpent(int timeSpent) {
        this.timeSpentInDay = timeSpent;
    }

}
