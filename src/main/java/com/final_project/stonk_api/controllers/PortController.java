package com.final_project.stonk_api.controllers;


import com.final_project.stonk_api.controllers.dto.PortDTO;
import com.final_project.stonk_api.entities.Port;
import com.final_project.stonk_api.service.PortService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/port")
public class PortController {

    private final PortService portService;

    public PortController(PortService portService) {
        this.portService = portService;
    }
    //keep
    @GetMapping
    public Iterable<Port> getPort(){
        return portService.findAll();
    }
    //keep
    @GetMapping("/{id}")
    public Port getPortById(@PathVariable("id") Integer id){

        return portService.findById(id);
    }
    //change
    @GetMapping("/name")
    public Iterable<Port> getPortByName(@RequestParam String name) {
        return portService.findByName(name);
    }

    //keep
    @PostMapping("/add")
    public Port createNewPort(@RequestBody PortDTO newPortDTO) {
        System.out.println("Port Controller");
        return portService.save(newPortDTO);
    }
    //keep
    @PutMapping("/{id}")
    public Port updatePort(
            @PathVariable("id") Integer portId,
            @RequestBody PortDTO portDTO
    ) {
        return portService.update(portId, portDTO);
    }
    //keep
    @DeleteMapping("/{id}")
    public Port deletePort(@PathVariable("id") Integer portId) {

        return portService.delete(portId);

    }

}
