package cz.martin.services;

import cz.martin.models.UniversitiesCount;
import cz.martin.models.University;
import cz.martin.repositories.UniversitiesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class UniversitiesService {
    @Inject
    private UniversitiesRepository universitiesRepository;

    public List<UniversitiesCount> getCounties() {
        return universitiesRepository.getCounties();
    }

    public List<University> getUniversities(String country) {
        return universitiesRepository.getUniversities(country);
    }
}