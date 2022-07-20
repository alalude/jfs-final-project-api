package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.HoldingDTO;
import com.final_project.stonk_api.entities.Holding;

import java.util.List;

public interface HoldingService {
    Holding save(HoldingDTO holdingDTO);
    Holding update(Integer holdingId, HoldingDTO holdingDTO);
    Holding delete(Integer holdingId);
    Iterable<Holding> findAll();
    Holding findById(Integer holdingId);
    //    change
    List<Holding> findByName(String name);
}
