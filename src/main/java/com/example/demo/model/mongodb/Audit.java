package com.example.demo.model.mongodb;

import org.springframework.data.annotation.Id;

public class Audit {

    @Id
    private String id;

    private String auditEvent;

    public Audit(String auditEvent, boolean exception) throws RuntimeException {
        if (exception) {
            throw new RuntimeException();
        }

        this.auditEvent = auditEvent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuditEvent() {
        return auditEvent;
    }

    public void setAuditEvent(String auditEvent) {
        this.auditEvent = auditEvent;
    }

}
