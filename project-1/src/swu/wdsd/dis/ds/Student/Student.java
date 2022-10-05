package swu.wdsd.dis.ds.Student;

public class Student{
    private String id;
    private String name;
    private int chinesescore;
    private int mathscore;
    private int englishscore;

    private int score;

    public Student() {

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getChineseScore() {
        return this.chinesescore;
    }

    public int getEnglishScore() {
        return this.englishscore;
    }

    public int getMathScore() {
        return this.mathscore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChineseScore(int chinesescore) {
        this.chinesescore = chinesescore;
    }

    public void setEnglishScore(int englishscore) {
        this.englishscore = englishscore;
    }

    public void setMathScore(int mathscore) {
        this.mathscore = mathscore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public int getTotalPoints(){
        return (getChineseScore()+getMathScore()+getEnglishScore());
    }
    public float getAverage(){
        return (getTotalPoints()/3);
    }

    public String toString() {
        return String.format("id:%s name:%s chinese_score:%s math_score:%s english_score:%s",this.getId(),this.getName(),this.getChineseScore(),this.getMathScore(),this.getEnglishScore());
    }






}





