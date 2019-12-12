package com.JourneyPlanner.JourneyPlannerBE.model.DAOs;

import com.JourneyPlanner.JourneyPlannerBE.model.Entities.Indirizzi;
import com.JourneyPlanner.JourneyPlannerBE.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class IndirizziDao
{

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

}
