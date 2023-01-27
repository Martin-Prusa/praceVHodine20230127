package cz.martin.beans;

import cz.martin.models.University;
import cz.martin.services.UniversitiesService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UniversitiesBean implements Serializable {
    @Inject
    private UniversitiesService universitiesService;

    private String country = "";

    public void c(String c) {
        country = c;
    }

    public List<University> getUniversities() {
        return universitiesService.getUniversities(country);
    }
}
