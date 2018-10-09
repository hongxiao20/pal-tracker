package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.util.List;

public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity create(TimeEntry timeEntry) {
        return null;
    }

    public TimeEntry find(Long id) {
        return null;
    }

    public ResponseEntity read(Long id) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    public ResponseEntity update(Long id, TimeEntry timeEntry) {
        return null;
    }


    public ResponseEntity<TimeEntry> delete(Long id) {
        return null;
    }


}
