package co.simplon.poo.ch9.tp1.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask {

    @Test
    public void testSetTimeSpent() {
        Task task = new Task();
        int timeSpent = 5;
        task.setTimeSpent(timeSpent);
        assertEquals(timeSpent, task.getTimeSpentInDay());
    }
}

