package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {

	
    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntry) {
    	TimeEntry result = timeEntryRepository.create(timeEntry);
    	if (result != null) {
    		return new ResponseEntity<>(result, HttpStatus.CREATED );
    	} else {
    		return null;
    	}   		
        
    }

    public TimeEntry find(Long id) {
    	return null;
    }

    public ResponseEntity<TimeEntry> read(Long id) {
    	TimeEntry result = timeEntryRepository.find(id);
    	if (result != null) {
    		return new ResponseEntity<>(result, HttpStatus.OK);
    	} else {
    		return null;
    	}
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
