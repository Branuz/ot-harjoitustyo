package com.poussu.studymate.trophies;

public class Trophy {
    private String name;
    private boolean completed;

    /**
     * Consturctor which contains the name and the completion status of a trophy
     * @param name of the trophy
     * @param completed completion status of the trophy
     */

    public Trophy(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    
    /** 
     * Used for setting the name of the trophy
     * @param name of the trophy
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Used for setting the completion of the trophy
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    /** 
     * Used for getting the name of the trophy
     * @return String name of the trophy
     */
    public String getName() {
        return this.name;
    }
    
    /** 
     * Used for getting the completion of the trophy
     * @return boolean completion status
     */
    public boolean getCompleted() {
        return this.completed;
    }

}
