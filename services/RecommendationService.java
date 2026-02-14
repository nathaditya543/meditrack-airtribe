package services;

import entities.Doctor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecommendationService {
    private final DocService docService;
    private final Map<String, String> symptomRules = new LinkedHashMap<>();

    public RecommendationService(DocService docService) {
        this.docService = docService;
        loadDefaultRules();
    }

    public void addRule(String symptomKeyword, String specialization) {
        symptomRules.put(symptomKeyword.toLowerCase(), specialization);
    }

    public String recommendSpecialization(String symptoms) {
        String text = symptoms.toLowerCase();
        for (Map.Entry<String, String> rule : symptomRules.entrySet()) {
            if (text.contains(rule.getKey())) {
                return rule.getValue();
            }
        }
        return "General";
    }

    public List<Doctor> recommendDoctors(String symptoms) {
        String specialization = recommendSpecialization(symptoms);
        List<Doctor> matches = docService.getDoctorsBySpec(specialization);
        if (!matches.isEmpty()) {
            return matches;
        }
        return docService.getDoctorsBySpec("General");
    }

    private void loadDefaultRules() {
        addRule("chest", "Cardiology");
        addRule("heart", "Cardiology");
        addRule("skin", "Dermatology");
        addRule("rash", "Dermatology");
        addRule("headache", "Neurology");
        addRule("migraine", "Neurology");
        addRule("pregnan", "Gynecology");
        addRule("child", "Pediatrics");
        addRule("bone", "Orthopedics");
        addRule("joint", "Orthopedics");
        addRule("stomach", "Gastroenterology");
        addRule("fever", "General");
    }
}
