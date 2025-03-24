package io.itch._tymon1.Lab3;

import io.itch._tymon1.Lab3.service.impl.ColonyService;
import io.itch._tymon1.Lab3.service.impl.EmpireService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    ColonyService colonyService;
    EmpireService empireService;

    @Autowired
    public DataInitializer(ColonyService colonyService, EmpireService empireService)
    {
        this.colonyService = colonyService;
        this.empireService = empireService;
    }

    @PostConstruct
    public void construct()
    {
        Empire[] empires = new Empire[4];
        empires[0] = Empire.builder().id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4a")).build();
        empires[1] = Empire.builder().id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4b")).build();
        empires[2] = Empire.builder().id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4c")).build();
        empires[3] = Empire.builder().id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4d")).build();


        for(Empire empire : empires)
        {
            empireService.save(empire);
        }

        Colony[] colonies = new Colony[6];
        colonies[0] = (Colony.builder().name("Nauvis").population(222167376).environment("Aired").mainExport("Processors").empire(empires[1]).id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0")).build());
        colonies[1] = (Colony.builder().name("Vulanas").population(2217376).environment("Volcanic").mainExport("Calcite").empire(empires[0]).id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c1")).build());
        colonies[2] = (Colony.builder().name("Fulgora").population(4222167376L).environment("Rocky").mainExport("Scrap").empire(empires[1]).id(UUID.randomUUID()).build());
        colonies[3] = (Colony.builder().name("Gleba").population(23722167376L).environment("Damp").mainExport("Biter Eggs").empire(empires[2]).id(UUID.randomUUID()).build());
        colonies[4] = (Colony.builder().name("Aquilo").population(863376).environment("Frozen").mainExport("Ammonia").empire(empires[0]).id(UUID.randomUUID()).build());
        colonies[5] = (Colony.builder().name("Prometheo").population(6737).environment("Destroyed").mainExport("Promethium").empire(empires[1]).id(UUID.randomUUID()).build());

        for(Colony colony : colonies)
        {
            colonyService.save(colony);
        }


    }
}
