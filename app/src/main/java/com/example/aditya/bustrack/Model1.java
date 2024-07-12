package com.example.aditya.bustrack;

public class Model1 {

    String id,name,email,mob,addr,sub,comp;

    public Model1(String id, String name, String email, String mob, String addr, String sub, String comp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mob = mob;
        this.addr = addr;
        this.sub = sub;
        this.comp = comp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }
}
