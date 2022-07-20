package com.final_project.stonk_api.repositories;

import com.final_project.stonk_api.entities.Holding;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HoldingRepository extends CrudRepository<Holding, Integer> {

    List<Holding> findByName(String name);
}
