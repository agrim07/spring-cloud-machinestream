package org.zeiss.processor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zeiss.processor.domain.MachineHealth;

@Repository
public interface MachineHealthRepository extends CrudRepository<MachineHealth, String> {
}
