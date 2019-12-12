package com.JourneyPlanner.JourneyPlannerBE.controllers;

import com.JourneyPlanner.JourneyPlannerBE.model.DAOs.MeteDao;
import com.JourneyPlanner.JourneyPlannerBE.model.Entities.Mete;
import com.JourneyPlanner.JourneyPlannerBE.utils.OrderPointsBody;
import com.JourneyPlanner.JourneyPlannerBE.utils.StaticLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/")
public class MyRestController
{
    @Autowired
    StaticLib sl;

    @CrossOrigin(origins = "*")
    @GetMapping(value="/findAll")
    public List<Mete> findAll()
    {
        MeteDao md = new MeteDao();
        return md.findAll();
    }

    @CrossOrigin(origins="*")
    @PostMapping(value="/orderPoints")
    public List<Mete> orderPoints(@RequestBody OrderPointsBody body)
    {
        return sl.orderPoints(body);
    }

}
