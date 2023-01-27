package cz.martin.services;

import cz.martin.repositories.CountriesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class CountriesService {
    @Inject
    private CountriesRepository countriesRepository;

    public List<String> getCounties() {
        return countriesRepository.getCounties();
    }
}