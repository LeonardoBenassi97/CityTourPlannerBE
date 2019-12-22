package com.JourneyPlanner.JourneyPlannerBE.utils;

public class OrderPointsBody
{
    private int orderingType;
    private int[] ids;

    public int getOrderingType() {
        return orderingType;
    }

    public void setOrderingType(int orderingType) {
        this.orderingType = orderingType;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
