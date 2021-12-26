package com.poussu.studymate.trophies;

public class Trophy {
   private String name;
   private boolean completed;
   private int requirement;
   private String type;

    public Trophy(String name, boolean completed, int requirement, String type) {
        this.name = name;
        this.completed = completed;
        this.requirement = requirement;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public int getRequirement(){
        return this.requirement;
    }
}
