package com.liber.api.services;

import com.liber.api.models.Section;
import com.liber.api.repositories.ISectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    ISectionRepository sectionRepository;

    @Autowired
    StateService stateService;

    public ArrayList<Section> getSections() {
        return (ArrayList<Section>) sectionRepository.findAll();
    }

    public Optional<Section> getSectionById (int id) {
        return sectionRepository.findById(id);
    }

    public Section saveSection (Section section) {
        return sectionRepository.save(section);
    }

    public Section updateSectionById(int id, Section request) {
        Optional<Section> optionalSection = sectionRepository.findById(id);

        if (optionalSection.isPresent()) {
            Section section = optionalSection.get();
            section.setName(request.getName());
            section.setDescription(request.getDescription());
            section.setState(request.getState());
            return sectionRepository.save(section);
        } else {
            throw new RuntimeException("Section not found with id " + id);
        }
    }

    public Boolean deleteSectionById (int id) {
        try {
            sectionRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
