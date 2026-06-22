public class FinancialForecasting{
    static double futureValue(double presentValue,double rate,int years){
        if(years==0){
            return presentValue;
        }
        return futureValue(presentValue,rate,years-1)*(1+rate);
    }

    public static void main(String[] args){
        double presentValue = 1200;
        double rate = 0.20;
        int years = 4;
        double result = futureValue(presentValue, rate, years);
        System.out.println("Present Value:" + presentValue);
        System.out.println("Growth Rate:" + (rate * 100) + "%");
        System.out.println("Years:" + years);
        System.out.println("Future Value:" + result);
    }
}