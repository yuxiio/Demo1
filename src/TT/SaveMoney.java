package TT;

public class SaveMoney {
    public static void main(String[] args) {
        ConstructionBank constructionBank = new ConstructionBank();
        BankGuangzhou bankGuangzhou = new BankGuangzhou();
        constructionBank.setYear(8.236);
        bankGuangzhou.setYear(8.236);
        constructionBank.setSavedMoney(8000);
        bankGuangzhou.setSavedMoney(8000);
        System.out.println("ConstructionBank's Interest = " + constructionBank.computerInterest());
        System.out.println("BankGuangzhou's Interest = " + bankGuangzhou.computerInterest());
        System.out.println("The difference between the interest of the two banks:" + (bankGuangzhou.interest - constructionBank.interest));
    }
}
