package org.zeiss.processor.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MachineHealthProcessor {

  String APPLICATIONS_IN = "events";
  String REPAIRED_OUT = "repaired";

  @Input(APPLICATIONS_IN)
  SubscribableChannel sourceOfMachineHealthApplications();

  @Output(REPAIRED_OUT)
  MessageChannel repaired();

}
