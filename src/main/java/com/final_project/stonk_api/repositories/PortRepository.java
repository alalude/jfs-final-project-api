package com.final_project.stonk_api.repositories;

import com.final_project.stonk_api.entities.Port;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PortRepository extends CrudRepository<Port, Integer> {
    List<Port> findByName(String name);
}
