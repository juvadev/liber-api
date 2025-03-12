package com.liber.api.controllers;

import com.liber.api.models.Section;
import com.liber.api.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ArrayList<Section> getSections () {
        return this.sectionService.getSections();
    }

    @GetMapping("/{id}")
    public Optional<Section> getSectionById (@PathVariable int id) {
        return this.sectionService.getSectionById(id);
    }

    @PostMapping("/save")
    public Section saveSection (@RequestBody Section section) {
        return this.sectionService.saveSection(section);
    }

    @PutMapping("/update/{id}")
    public Section updateSectionById (@PathVariable int id, @RequestBody Section request) {
        return this.sectionService.updateSectionById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteSectionById (@PathVariable int id) {
        return this.sectionService.deleteSectionById(id);
    }
}
