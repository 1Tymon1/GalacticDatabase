package io.itch._tymon1.Lab3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {

    EmpireService empireService;

    @Autowired
    public DataInitializer(EmpireService empireService)
    {
        this.empireService = empireService;
    }

    @PostConstruct
    public void construct()
    {
        Empire[] empires = new Empire[4];
        empires[0] = Empire.builder().name("Hegemony").population(324423423475L).starSystems(57).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4a")).build();
        empires[1] = Empire.builder().name("Terran_Coalition").population(772423473475L).starSystems(143).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4b")).build();
        empires[2] = Empire.builder().name("Glumeria").population(24423339475L).starSystems(8).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4c")).build();
        empires[3] = Empire.builder().name("New_empire").population(24444475L).starSystems(1).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4d")).build();


        for(Empire empire : empires)
        {
            empireService.save(empire);
        }
    }
}
