package Lab12;

public class Student {
    String name;
    double mathScore;
    double englishScore;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    double sum() {
        return mathScore + englishScore;
    }
}
