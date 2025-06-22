package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private  final AIService aiService;


    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository,
                                   AIService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers()
    {
        return softwareEngineerRepository.findAll();
    }


    public void insertSoftwareEngineer( SoftwareEngineer softwareEngineer) {
        String prompt= """
               Based on the Programming tech stak %s that %s has given
               Provide a full learning Path and recommendations for this person.
                """.formatted(softwareEngineer.getTechStack(),
                softwareEngineer.getName()
        );
        String chatRes= aiService.chat(prompt);
        softwareEngineer.setLearningPathRecommendation(chatRes);
        softwareEngineerRepository.save(softwareEngineer);
    }

    public List<SoftwareEngineer> getSoftwareEngineerById(Integer id) {

        return Collections.singletonList(softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found ")));
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(id + "not found");
        };
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerByID(SoftwareEngineer softwareEngineer) {

        softwareEngineerRepository.save(softwareEngineer);
    }
}
