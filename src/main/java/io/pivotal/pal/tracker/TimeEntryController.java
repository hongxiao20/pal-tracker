package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/")
public class TimeEntryController {

	
    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
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

    @GetMapping("time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
    	TimeEntry result = timeEntryRepository.find(id);
    	if (result != null) {
    		return new ResponseEntity<>(result, HttpStatus.OK);
    	} else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }

    @GetMapping("time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        if (timeEntryList != null) {
            return new ResponseEntity<>(timeEntryList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry result = timeEntryRepository.update(id, timeEntry);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {

        TimeEntry result = timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
