package com.spartez.interviews.eventsystem.mockevents;

import com.spartez.interviews.eventsystem.Event;

public class NewSpecificTestEvent extends BaseTestEvent implements Event {
    public NewSpecificTestEvent() {
        System.out.println("New Me");
    }
}