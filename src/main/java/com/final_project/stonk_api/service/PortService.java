package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.PortDTO;
import com.final_project.stonk_api.entities.Port;

import java.util.List;

public interface PortService {
    Port save(PortDTO portDTO);
    Port update(Integer portId, PortDTO portDTO);
    Port delete(Integer portId);
    Iterable<Port> findAll();
    Port findById(Integer portId);
    //    change
    List<Port> findByName(String name);
}
