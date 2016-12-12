package com.sgsaez.materialtransitions.model;

import java.io.Serializable;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class Player implements Serializable {

    private String name;
    private String description;
    private int photo;
    private int shield;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setShield(int shield) {
        this.shield = shield;
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

    public int getShield() {
        return shield;
    }

    public Player(Player.PlayerBuilder builder){
        name = builder.name;
        description = builder.description;
        photo = builder.photo;
        shield = builder.shield;
    }

    public static class PlayerBuilder {
        private String name;
        private String description;
        private int photo;
        private int shield;

        public Player.PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Player.PlayerBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Player.PlayerBuilder setPhoto(int photo) {
            this.photo = photo;
            return this;
        }

        public Player.PlayerBuilder setShield(int shield) {
            this.shield = shield;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }

}
