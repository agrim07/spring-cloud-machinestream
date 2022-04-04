package org.zeiss.processor.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.zeiss.processor.config.MachineHealthProcessor;
import org.zeiss.processor.domain.MachineHealth;
import org.zeiss.processor.service.MachineHealthService;

@Component
public class MachineHealthExecutor {

  public static final Logger log = LoggerFactory.getLogger(MachineHealthExecutor.class);

  private static  final String IDLE_STATUS = "IDLE";
  private static  final String ERRORED_STATUS = "ERRORED";

  private MachineHealthProcessor processor;
  private MachineHealthService service;

  @Autowired
  public MachineHealthExecutor(MachineHealthProcessor processor, MachineHealthService service) {
    this.processor = processor;
    this.service = service;
  }

  @StreamListener(MachineHealthProcessor.APPLICATIONS_IN)
  public void executeMachineHealthEvent(MachineHealth machineHealth) {
    log.info("Event received machine_id: {}, id: {}, timestamp: {} and status {}", machineHealth.getMachine_id(),
            machineHealth.getId(), machineHealth.getTimestamp(), machineHealth.getStatus());

    if (ERRORED_STATUS.equals(machineHealth.getStatus())) {
      processor.repaired().send(message(machineHealth));
      machineHealth.setStatus(IDLE_STATUS);
    }
    service.storeMachineHealthEvent(machineHealth);
  }

  private static final <T> Message<T> message(T val) {
    return MessageBuilder.withPayload(val).build();
  }
}
