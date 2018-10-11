package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/")
public class TimeEntryController {

	
    private TimeEntryRepository timeEntryRepository;

//    @Autowired
//    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
//        this.timeEntryRepository = timeEntryRepository;
//    }

    private final CounterService counter;
    private final GaugeService gauge;
//    private final TimeEntryRepository timeEntriesRepo;

    public TimeEntryController(
            TimeEntryRepository timeEntriesRepo,
            CounterService counter,
            GaugeService gauge
    ) {
        this.timeEntryRepository = timeEntriesRepo;
        this.counter = counter;
        this.gauge = gauge;
    }

    @PostMapping("time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
    	TimeEntry result = timeEntryRepository.create(timeEntry);
    	if (result != null) {
            counter.increment("TimeEntry.created");
            gauge.submit("timeEntries.count", timeEntryRepository.list().size());
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
            counter.increment("TimeEntry.read");
           return new ResponseEntity<>(result, HttpStatus.OK);
    	} else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }

    @GetMapping("time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        if (timeEntryList != null) {
            counter.increment("TimeEntry.listed");
            return new ResponseEntity<>(timeEntryList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry result = timeEntryRepository.update(id, timeEntry);
        if (result != null) {
            counter.increment("TimeEntry.updated");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
        counter.increment("TimeEntry.deleted");
        gauge.submit("timeEntries.count", timeEntryRepository.list().size());
        TimeEntry result = timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
