package org.zeiss.processor;

import org.zeiss.processor.config.MachineHealthProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(MachineHealthProcessor.class)
public class MachineHealthProcessorApplication {

  public static final Logger log = LoggerFactory.getLogger(MachineHealthProcessorApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(MachineHealthProcessorApplication.class, args);
    log.info("The Machine Health Processor Application has started...");
  }
}
