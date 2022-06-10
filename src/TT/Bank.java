package TT;

public class Bank {
    int year;
    double savedMoney;
    double interest;
    public double computerInterest(){
        interest = year * 0.05 * savedMoney;
        return interest;
    }

    public void setSavedMoney(double savedMoney) {
        this.savedMoney = savedMoney;
    }
}

class ConstructionBank extends Bank{
    double year;

    @Override
    public double computerInterest() {
        super.year = (int)year;
        super.computerInterest();
        interest += 0.03/365 * savedMoney * (year-super.year)*1000;
        return  interest;
    }

    public void setYear(double year) {
        this.year = year;
    }
}

class BankGuangzhou extends Bank{
    double year;

    @Override
    public double computerInterest() {
        super.year = (int)year;
        super.computerInterest();
        interest += 0.04/365 * savedMoney * (year-super.year)*1000;
        return  interest;
    }

    public void setYear(double year) {
        this.year = year;
    }
}