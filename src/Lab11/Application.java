package Lab11;

public class Application {
    public static void main(String[] args) {
        double [] stu_Score = {83,82,88,90,93,85,77,95,83,87,88};
        double [] singer_Score = {90,91,92,98,94,88,89,90,92,96};
        SongGame songGame = new SongGame();
        School school = new School();
        System.out.println("the average Score of student is " + school.average(stu_Score));
        System.out.println("the average Score of singer is " + school.average(singer_Score));
    }
}
