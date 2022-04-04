package org.zeiss.processor.domain;

import javax.persistence.*;

@Entity
public class MachineHealth {

    @Id
    @Column(name = "machine_id")
    private String machine_id;

    @Column(name = "id")
    private String id;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "status")
    private String status;

    public MachineHealth(){

    }

    public MachineHealth(String id, String machine_id, String timestamp, String status) {
        this.id = id;
        this.machine_id = machine_id;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status.toUpperCase();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
