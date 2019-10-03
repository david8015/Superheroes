package com.GA.Superheroes;

public class Superhero {
    private String name;
    private String patrolsCity;
    private String realName;

    public Superhero() {
    }

    public Superhero(String name, String patrolsCity, String realName) {
        this.name = name;
        this.patrolsCity = patrolsCity;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatrolsCity() {
        return patrolsCity;
    }

    public void setPatrolsCity(String patrolsCity) {
        this.patrolsCity = patrolsCity;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
