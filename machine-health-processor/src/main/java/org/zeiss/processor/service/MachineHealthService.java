package org.zeiss.processor.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.zeiss.processor.config.MachineHealthProcessor;
import org.zeiss.processor.domain.MachineHealth;
import org.zeiss.processor.repository.MachineHealthRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MachineHealthService {

    private static  final String IDLE_STATUS = "IDLE";
    private static  final String ERRORED_STATUS = "ERRORED";

    private MachineHealthProcessor processor;
    private MachineHealthRepository repository;

    public MachineHealthService(MachineHealthProcessor processor, MachineHealthRepository repository) {
        this.processor = processor;
        this.repository = repository;
    }

    public boolean storeMachineHealthEvent(MachineHealth machineHealth) {
        if (ERRORED_STATUS.equals(machineHealth.getStatus().toUpperCase(Locale.ROOT))) {
            processor.repaired().send(message(machineHealth));
            machineHealth.setStatus(IDLE_STATUS);
        }
        machineHealth = repository.save(machineHealth);
        return null != machineHealth;
    }

    public List<MachineHealth> fetchAllMachineHealthEvent() {
        Iterable<MachineHealth> machinesHealth = repository.findAll();
        List<MachineHealth> machinesHealthList = StreamSupport.stream(machinesHealth.spliterator(), false).collect(Collectors.toList());
        return machinesHealthList;
    }

    public Optional<MachineHealth> fetchMachineHealthEventById(String machineId) {
        Optional<MachineHealth> machineHealth = repository.findById(machineId);
        return machineHealth;
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
