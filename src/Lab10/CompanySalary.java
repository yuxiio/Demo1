package Lab10;

public class CompanySalary {
    public static void main(String[] args) {
        Company company = new Company();
        company.employees = new Employee[30];
        for(int i=0;i<30;i++){
            if(i%3==0)
                company.employees[i] = new YearWorker();
            else if(i%3==1)
                company.employees[i] = new MonthWorker();
            else
                company.employees[i] = new WeekWorker();
        }
        double salarySum = 0;
        for (int i=0;i<30;i++){
            salarySum += company.employees[i].earnings();
        }
        System.out.println("this company's salary sum is :"+salarySum);
    }
}
