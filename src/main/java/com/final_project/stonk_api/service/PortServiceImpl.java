package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.PortDTO;
import com.final_project.stonk_api.entities.Port;
import com.final_project.stonk_api.repositories.PortRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PortServiceImpl implements PortService {


    private final PortRepository portRepository;

    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public Port save(PortDTO portDTO){
        System.out.println("Service Implementation");
        Port port = new Port(portDTO);
        return portRepository.save(port);
    }

    @Override
    public Port update(Integer id, PortDTO p) {
        Optional<Port> portToUpdateOptional = portRepository.findById(id);
        if (portToUpdateOptional.isEmpty()) {
            return null;
        }
        Port portToUpdate = portToUpdateOptional.get();

        if (p.getName() != null) {
            portToUpdate.setName(p.getName());
        }
//        if (p.getAvatar() != null) {
//            portToUpdate.setAvatar(p.getAvatar());
//        }
//        if (t.getOwner() != null) {
//            portToUpdate.setOwner(t.getOwner());
//        }
        return portRepository.save(portToUpdate);
    }

    @Override
    public Port delete(Integer portId) {

        Optional<Port> portToDeleteOptional = portRepository.findById(portId);
        if (portToDeleteOptional.isEmpty()) {
            return null;
        }
        Port portToDelete = portToDeleteOptional.get();
        portRepository.delete(portToDelete);
        return portToDelete;

    }

    @Override
    public Iterable<Port> findAll() {
        return portRepository.findAll();
    }

    @Override
    public Port findById(Integer portId) {

        Optional<Port> optionalPort = portRepository.findById(portId);
        if(optionalPort.isEmpty()){
            // throw an exception if the ID is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no portfolio with the ID provided.");
        }
        return optionalPort.get();
    }

    @Override
    public List<Port> findByName(String name) {
        List<Port> optionalPort = portRepository.findByName(name);
        if(optionalPort.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no portfolio with the first name provided.");
        }
        return portRepository.findByName(name);
    }

}
