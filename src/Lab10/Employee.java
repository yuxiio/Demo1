package Lab10;

public abstract class Employee {
    public abstract double earnings();
}

class YearWorker extends Employee{
    @Override
    public double earnings() {
        return 24000;
    }
}

class MonthWorker extends Employee{
    @Override
    public double earnings() {
        return 12 * 3000;
    }
}

class WeekWorker extends Employee{
    @Override
    public double earnings() {
        return 52 * 1000;
    }
}
