public class Calc {
    String productName;
    double productsSum, sumPerPerson;
    int countOfPersons;

    void add(String pName, double pSum) {
        productName = productName + pName + "\n";
        productsSum = productsSum + pSum;
        sumPerPerson = productsSum / countOfPersons;
    }

    Calc (String pName, int cPer) {
        productName = pName;
        countOfPersons = cPer;
    }
}