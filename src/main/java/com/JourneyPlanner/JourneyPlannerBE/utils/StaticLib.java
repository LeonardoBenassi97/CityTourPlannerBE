package com.JourneyPlanner.JourneyPlannerBE.utils;

import com.JourneyPlanner.JourneyPlannerBE.model.DAOs.MeteDao;
import com.JourneyPlanner.JourneyPlannerBE.model.Entities.Mete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaticLib
{
    @Autowired
    MeteDao md;

    public List<Mete> orderPoints(OrderPointsBody body)
    {
        List<Mete> result = null;
        //TODO: IMPLEMENT POINT ORDERING
        if (body.getOrderingType() == 0)
        {
            result = linearOrderPoints(body.getIds());
        }
        else if(body.getOrderingType() == 1)
        {
            result = circleOrderPoints(body.getIds());
        }

        return result;
    }

    private final static double AVERAGE_RADIUS_OF_EARTH_M = 6371000;
    public static int calculateDistanceInMeters(double userLat, double userLng,
                                                 double venueLat, double venueLng)
    {

        double latDistance = (userLat - venueLat); //Math.toRadians(userLat - venueLat);
        double lngDistance = (userLng - venueLng); //Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_M * c));
    }

    public ArrayList<Mete> linearOrderPoints(int[] ids)
    {
        ArrayList<Mete> result = new ArrayList<>();

        //adding starting point to avoid the NullPointerException
        result.add(md.findById(ids[0]));

        if (CollectionUtils.isEmpty(result))
            return null;
        while (result.size() < ids.length)
        {
            int closestDistance = 0;
            Mete closestMeta = new Mete();
            for (int id : ids) {
                Mete m = md.findById(id);
                if (!result.contains(m)) {
                    int distance = calculateDistanceInMeters(Double.parseDouble(m.getLatitudine()),
                                                             Double.parseDouble(m.getLongitudine()),
                                                             Double.parseDouble(result.get(result.size() - 1).getLatitudine()),
                                                             Double.parseDouble(result.get(result.size() - 1).getLongitudine()));
                    if (distance < closestDistance || closestDistance == 0) {
                        closestDistance = distance;
                        closestMeta = m;
                    }
                }
            }
            result.add(closestMeta);
        }

        return result;
    }

    public List<Mete> circleOrderPoints(int[] ids)
    {
        ArrayList<Mete> andata = new ArrayList<>();
        ArrayList<Mete> ritorno = new ArrayList<>();
        for (int i = 0; i< (ids.length /2); i++)
        {
            Mete m = md.findById(i);
            int distance;
            if (i == 0) {
                andata.add(m);
                ritorno.add(m);
            }

        }

        return null;
    }

    public static int[] divideArrayByTwo(int num)
    {
        int[] arrays = new int[2];
        if(num%2 == 1)
        {
            arrays[0] = (num-1)/2;
            arrays[1] = (num+1)/2;
        }
        else
        {
            arrays[0] = num/2;
            arrays[1] = num/2;
        }
        return arrays;
    }

}
