package com.example.aditya.bustrack;

public class Model2 {

    String id,type,mob,veh,date,feed,desc;

    public Model2(){}

    public Model2(String id, String type, String mob, String veh, String date, String feed, String desc) {
        this.id = id;
        this.type = type;
        this.mob = mob;
        this.veh = veh;
        this.date = date;
        this.feed = feed;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getVeh() {
        return veh;
    }

    public void setVeh(String veh) {
        this.veh = veh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
