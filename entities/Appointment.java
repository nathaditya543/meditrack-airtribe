package entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Appointment {
    int id;
    int docId;
    int patId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    long durationMinutes;

    Appointment(int id, int docId, int patId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.docId = docId;
        this.patId = patId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationMinutes = Duration.between(startTime, endTime).toMinutes();
    }

    int getId() {
        return id;
    }

    int getDocId() {
        return docId;
    }

    int getPatId() {
        return patId;
    }

    LocalDateTime getStartTime() {
        return startTime;
    }

    LocalDateTime getEndTime() {
        return endTime;
    }

    long getDurationMinutes() {
        return durationMinutes;
    }
}
