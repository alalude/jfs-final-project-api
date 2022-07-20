package com.final_project.stonk_api.controllers;

import com.final_project.stonk_api.controllers.dto.HoldingDTO;
import com.final_project.stonk_api.entities.Holding;
import com.final_project.stonk_api.service.HoldingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/holding")
public class HoldingController {

    private final HoldingService holdingService;

    public HoldingController(HoldingService holdingService) {
        this.holdingService = holdingService;
    }
    //keep
    @GetMapping
    public Iterable<Holding> getHolding(){
        return holdingService.findAll();
    }
    //keep
    @GetMapping("/{id}")
    public Holding getHoldingById(@PathVariable("id") Integer id){

        return holdingService.findById(id);
    }
    //change
    @GetMapping("/name")
    public Iterable<Holding> getHoldingByName(@RequestParam String name) {
        return holdingService.findByName(name);
    }

    //keep
    @PostMapping("/add")
    public Holding createNewHolding(@RequestBody HoldingDTO newHoldingDTO) {
        return holdingService.save(newHoldingDTO);
    }
    //keep
    @PutMapping("/{id}")
    public Holding updateHolding(
            @PathVariable("id") Integer holdingId,
            @RequestBody HoldingDTO holdingDTO
    ) {
        return holdingService.update(holdingId, holdingDTO);
    }
    //keep
    @DeleteMapping("/{id}")
    public Holding deleteHolding(@PathVariable("id") Integer holdingId) {

        return holdingService.delete(holdingId);

    }

}
