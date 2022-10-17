package swu.wdsd.dis.ds.Student;

public class Student{
    private String id;
    private String name;
    private int chinese_score;
    private int math_score;
    private int english_score;

    private int score;

    public Student(String id, String name, int chinese_score, int math_score, int english_score) {

    }

    public Student() {

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getChinese_score() {
        return this.chinese_score;
    }

    public int getEnglish_score() {
        return this.english_score;
    }

    public int getMath_score() {
        return this.math_score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChinese_score(int chinese_score) {
        this.chinese_score = chinese_score;
    }

    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }

    public void setMath_score(int math_score) {
        this.math_score = math_score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public int getTotalPoints(){
        return (this.chinese_score+getMath_score()+getEnglish_score());
    }
    public float getAverage(){
        return (getTotalPoints()/3);
    }

    public String toString() {
        return String.format("id:%s name:%s chinese_score:%s math_score:%s english_score:%s",this.getId(),this.getName(),this.getChinese_score(),this.getMath_score(),this.getEnglish_score());
    }






}





