package com.JourneyPlanner.JourneyPlannerBE.model.DAOs;

import com.JourneyPlanner.JourneyPlannerBE.model.Entities.Mete;
import com.JourneyPlanner.JourneyPlannerBE.model.repos.MeteRepository;
import com.JourneyPlanner.JourneyPlannerBE.utils.JpaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class MeteDao {

    @Autowired
    private MeteRepository mr;

    //TODO: QUERY PAGINATION
    public List<Mete> findAll()
    {
        EntityManager em = null;
        List<Mete> lista = null;

        try {
            JpaUtils jpu = JpaUtils.getInstance();

            em = jpu.getEntityManager();

            TypedQuery<Mete> query =
                    em.createNamedQuery("Mete.findAll", Mete.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public Mete findById(int id)
    {
        //EntityManager em = null;
        Mete result = null;
        String idToString = Integer.toString(id);

        try {
//            JpaUtils jpu = JpaUtils.getInstance();
//
//            em = jpu.getEntityManager();
//
//            String sqlQuery = "select m from Mete m where m.id = :id";
//
//            Query q = em.createQuery(sqlQuery);
//
//            q.setParameter("id", idToString);
//
//            result = (Mete) q.getSingleResult();
            if (mr.findById(idToString).isPresent())
            {
                result = mr.findById(idToString).get();
            }

        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
        //finally {
        //    em.close();
        //}
        return result;
    }

}