package org.zeiss.healthsource.domain;

public class MachineHealth {

    private String machine_id, id, timestamp, health;

    public MachineHealth(){

    }

    public MachineHealth(String machine_id, String id, String timestamp, String health) {
        this.machine_id = machine_id;
        this.id = id;
        this.timestamp = timestamp;
        this.health = health;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "MachineHealth{" +
                "machine_id='" + machine_id + '\'' +
                ", id='" + id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", status=" + health +
                '}';
    }
}
