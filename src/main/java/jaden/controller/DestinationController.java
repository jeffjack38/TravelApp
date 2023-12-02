package jaden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jaden.model.Destination;
import jaden.service.DestinationService;

import java.util.List;



@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }
    
    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    // Other CRUD operations and business logic as needed
}
