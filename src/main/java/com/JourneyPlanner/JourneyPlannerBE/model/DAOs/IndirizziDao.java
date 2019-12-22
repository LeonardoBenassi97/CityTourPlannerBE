package com.JourneyPlanner.JourneyPlannerBE.model.DAOs;

import com.JourneyPlanner.JourneyPlannerBE.model.Entities.Indirizzi;
import com.JourneyPlanner.JourneyPlannerBE.model.repos.IndirizziRepository;
import com.JourneyPlanner.JourneyPlannerBE.model.repos.MeteRepository;
import com.JourneyPlanner.JourneyPlannerBE.utils.JpaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class IndirizziDao
{

    @Autowired
    private IndirizziRepository ir;


    //TODO: QUERY PAGINATION
    public List<Indirizzi> findAll()
    {
        EntityManager em = null;
        List<Indirizzi> lista = null;

        try {
            JpaUtils jpu = JpaUtils.getInstance();

            em = jpu.getEntityManager();

            TypedQuery<Indirizzi> query =
                    em.createNamedQuery("Mete.findAll", Indirizzi.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public List<String> getCities()
    {
        List<Indirizzi> tmp = findAll();
        List<String> r = null;
        for (Indirizzi i : tmp)
        {
            r.add(i.getCitta());
        }
        return r;
    }

}
