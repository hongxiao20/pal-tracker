
package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    HashMap<Long, TimeEntry> timeEntryHashMap = new HashMap<Long, TimeEntry>();
    long mapIndex = 0;

    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry storeTimeEntry = new TimeEntry();

        mapIndex ++;
        storeTimeEntry.setId(mapIndex);
        storeTimeEntry.setDate(timeEntry.getDate());
        storeTimeEntry.setHours(timeEntry.getHours());
        storeTimeEntry.setProjectId(timeEntry.getProjectId());
        storeTimeEntry.setUserId(timeEntry.getUserId());
        timeEntryHashMap.put(storeTimeEntry.getId(), storeTimeEntry);

//        TimeEntry var = timeEntryHashMap.get(storeTimeEntry.getId());
//        System.out.println("timeEntryHashMap - " + var);

        return storeTimeEntry;
    }

    public TimeEntry find(long id) {

        TimeEntry timeEntry = timeEntryHashMap.get(id);
        System.out.println("timeEntryHashMap - " + timeEntry);

        return timeEntry;
    }

    public List<TimeEntry> list() {

        List<TimeEntry> storeTimeEntryList = new ArrayList(timeEntryHashMap.values());

//        for (TimeEntry t: timeEntryHashMap.values()) {
//            storeTimeEntryList.add(t);
//        }

        return storeTimeEntryList;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updateTimeEntry = timeEntryHashMap.get(id);
        updateTimeEntry.setUserId(timeEntry.getUserId());
        updateTimeEntry.setDate(timeEntry.getDate());
        updateTimeEntry.setHours(timeEntry.getHours());
        updateTimeEntry.setProjectId(timeEntry.getProjectId());

        return updateTimeEntry;

    }

    public TimeEntry delete(long id) {
        //TimeEntry response = timeEntryHashMap.get(id);
        TimeEntry response = timeEntryHashMap.remove(id);
        return response;


    }

}
