package com.sgsaez.materialtransitions.model;

import java.io.Serializable;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public class Pilot implements Serializable {

    private String name;
    private String description;
    private int photo;
    private int teamCar;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setTeamCar(int teamCar) {
        this.teamCar = teamCar;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoto() {
        return photo;
    }

    public int getTeamCar() {
        return teamCar;
    }

    private Pilot (Pilot.PilotBuilder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.photo = builder.photo;
        this.teamCar = builder.teamCar;
    }

    public static class PilotBuilder{
        private String name;
        private String description;
        private int photo;
        private int teamCar;

        public Pilot.PilotBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Pilot.PilotBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Pilot.PilotBuilder setPhoto(int photo) {
            this.photo = photo;
            return this;
        }

        public Pilot.PilotBuilder setTeamCar(int teamCar) {
            this.teamCar = teamCar;
            return this;
        }

        public Pilot build(){
            return new Pilot(this);
        }
    }

}
