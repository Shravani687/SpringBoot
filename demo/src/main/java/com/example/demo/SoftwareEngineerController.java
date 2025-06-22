package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers()
    {
        return softwareEngineerService.getAllSoftwareEngineers();
    }
    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id)
    {
        return (SoftwareEngineer) softwareEngineerService.getSoftwareEngineerById(id);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public void  updateSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer)
    {
        softwareEngineerService.updateSoftwareEngineerByID(softwareEngineer);
    }
    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer)
    {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

}
