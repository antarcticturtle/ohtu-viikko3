package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public void setHours(int hours){
        this.hours = hours;
    }
    
    public int getHours(){
        return this.hours;
    }
    
    public void setExercises(int[] exercises){
        this.exercises = new int[exercises.length];
        for (int i = 0; i < exercises.length; i++){
            this.exercises[i] = exercises[i];
        }
    }
    
    public int[] getExercises(){
        return this.exercises;
    }
    
    private String exString(){
        String str = "";
        for(int i = 0; i < exercises.length-1; i++){
            str += exercises[i] + ", ";
        }
        str += exercises[exercises.length-1];
        return str;
    }
    
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public String getCourse(){
        return this.course;
    }
    

    @Override
    public String toString() {
        return course + ", viikko " + week + ": \n tehtyjä tehtäviä yhteensä "+ exercises.length+", aikaa kului "+ hours+", tehdyt tehtävät: " + exString();
    }
    
}