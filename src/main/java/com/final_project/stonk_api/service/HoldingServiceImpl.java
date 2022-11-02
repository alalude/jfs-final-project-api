package com.final_project.stonk_api.service;

import com.final_project.stonk_api.controllers.dto.HoldingDTO;
import com.final_project.stonk_api.entities.Holding;
import com.final_project.stonk_api.repositories.HoldingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingServiceImpl implements HoldingService {

    private final HoldingRepository holdingRepository;

    public HoldingServiceImpl(HoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @Override
    public Holding save(HoldingDTO holdingDTO){
        Holding holding = new Holding(holdingDTO);
        return holdingRepository.save(holding);
    }

    @Override
    public Holding update(Integer id, HoldingDTO h) {
        Optional<Holding> holdingToUpdateOptional = holdingRepository.findById(id);
        if (holdingToUpdateOptional.isEmpty()) {
            return null;
        }
        Holding holdingToUpdate = holdingToUpdateOptional.get();

        if (h.getName() != null && !h.getName().isEmpty()) {
            holdingToUpdate.setName(h.getName());
        }
        if (h.getTargetPrice() != null) {
            holdingToUpdate.setTargetPrice(h.getTargetPrice());
        }

        if (h.getPurchaseQuantity() != null) {
            holdingToUpdate.setPurchaseQuantity(h.getPurchaseQuantity());
        }

        if (h.getPurchasePrice() != null) {
            holdingToUpdate.setPurchasePrice(h.getPurchasePrice());
        }

        if (h.getPortId() != null) {
            holdingToUpdate.setPortId(h.getPortId());
        }

        return holdingRepository.save(holdingToUpdate);
    }

    @Override
    public Holding delete(Integer holdingId) {

        Optional<Holding> holdingToDeleteOptional = holdingRepository.findById(holdingId);
        if (holdingToDeleteOptional.isEmpty()) {
            return null;
        }
        Holding holdingToDelete = holdingToDeleteOptional.get();
        holdingRepository.delete(holdingToDelete);
        return holdingToDelete;

    }

    @Override
    public Iterable<Holding> findAll() {
        return holdingRepository.findAll();
    }

    @Override
    public Holding findById(Integer holdingId) {

        Optional<Holding> optionalHolding = holdingRepository.findById(holdingId);
        if(optionalHolding.isEmpty()){
            // throw an exception if the ID is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no holding with the ID provided.");
        }
        return optionalHolding.get();
    }

    @Override
    public List<Holding> findByName(String name) {
        List<Holding> optionalHolding = holdingRepository.findByName(name);
        if(optionalHolding.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no holding with the name provided.");
        }
        return holdingRepository.findByName(name);
    }
    
    
}
