package org.zeiss.healthsource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zeiss.healthsource.domain.MachineHealth;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class MachineHealthsourceApplication {

  private static final Logger log = LoggerFactory.getLogger(MachineHealthsourceApplication.class);

  private static  final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
  private static  final String IDLE_STATUS = "IDLE";
  private static  final String RUNNING_STATUS = "RUNNING";
  private static  final String FINISHED_STATUS = "FINISHED";
  private static  final String ERRORED_STATUS = "ERRORED";
  private static final SimpleDateFormat sdf2 = new SimpleDateFormat(TIMESTAMP_FORMAT);
  private List<String> statuses = Arrays.asList(IDLE_STATUS, RUNNING_STATUS, FINISHED_STATUS, ERRORED_STATUS);


  public static void main(String[] args) {
    SpringApplication.run(MachineHealthsourceApplication.class, args);
    log.info("The Machine Health Source Application has started...");
  }

  @Bean
  public Supplier<MachineHealth> supplyMachineHealth(){

    Supplier<MachineHealth> machineHealthSupplier = () -> {
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      MachineHealth machineHealth = new MachineHealth(UUID.randomUUID().toString(),
              UUID.randomUUID().toString(), sdf2.format(timestamp),
              statuses.get(new Random().nextInt(statuses.size())));
      log.info("machine_id: {}, id: {}, timestamp: {} and status {}", machineHealth.getMachine_id(),
              machineHealth.getId(), machineHealth.getTimestamp(), machineHealth.getHealth());
      return machineHealth;
    };

    return machineHealthSupplier;
  }
}
