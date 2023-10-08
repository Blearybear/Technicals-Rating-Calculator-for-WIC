import java.util.Scanner;
public class Main {
    static String investmentHorizon;
    static String stockName;
    static double price;

    static int price20SMA, price50SMA, price200SMA, price8EMA;
    static double rsi;
    static double macd, macdSignal;

    static double adx, diPlus, diMinus;

    static double aroonUp, aroonDown;
    static double leadingA, leadingB, conversion, base;
    static int parabolicSAR;
    static int vortexVI;
    static double manual;
    static double finalRating = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticker of the stock/ETF: ");
        stockName = scanner.nextLine();
        System.out.println("Enter the current price of the stock/ETF: ");
        price = scanner.nextDouble();
        System.out.println("Investment Horizon [\"mid\"] [\"long\"]: ");
        investmentHorizon = scanner.next();
        while (!investmentHorizon.equals("mid") && !investmentHorizon.equals("long")){
            System.out.println("Please enter a valid time horizon, [mid] for mid-term [long] for long-term.");
            investmentHorizon = scanner.next();
        }
        infoCollect();
        if (investmentHorizon.equals("mid")){
            midTerm();
        }
        else{
            longTerm();
        }
        finalRating = finalRating / 22.5;
        System.out.println("Final Rating for " + stockName + ": " + finalRating + "\nAs a " + investmentHorizon + "-term investment based on technicals.");
        }
        public static void longTerm(){
            if (price20SMA == 0){
                finalRating++;
            }
            if (price50SMA == 0){
                finalRating += 3;
            }
            if (price200SMA == 0){
                finalRating += 7;
            }
            if (price8EMA == 0){
                finalRating += 2;
            }
            if (rsi > 70){
                finalRating -= 0.5;
            }
            else if (rsi < 30){
                finalRating += 0.5;
            }
            if (macd > macdSignal){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            if (macd > 0){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            if (adx > 25){
                if (diPlus > diMinus){
                    finalRating += 0.5;
                }
                else finalRating -= 0.5;
            }
            else {
                if (diPlus > diMinus){
                    finalRating += 0.25;
                }
                else finalRating -= 0.25;
            }
            if (aroonUp > aroonDown){
                finalRating += (aroonUp - aroonDown)/100;
            }
            else finalRating -= (aroonDown - aroonUp)/100;
            if (leadingA > leadingB){
                finalRating++;
                if (price > leadingA){ // > range
                    finalRating++;
                    if (conversion > base){
                        finalRating += 2.5;
                    }
                    else finalRating -= 0.5;
                }
                else if (price < leadingB){ // < range
                    finalRating--;
                    if (conversion < base){
                        finalRating -= 2.5;
                    }
                    else finalRating += 0.5;
                }
                else { // in range
                    if (conversion > base){
                        finalRating += 0.5;
                    }
                    else finalRating -= 0.5;
                }
            }
            else {
                finalRating--;
                if (price > leadingB){ // > range
                    finalRating++;
                    if (conversion > base){
                        finalRating += 2.5;
                    }
                    else finalRating -= 0.5;
                }
                else if (price < leadingA){ // < range
                    finalRating--;
                    if (conversion < base){
                        finalRating -= 2.5;
                    }
                    else finalRating += 0.5;
                }
                else { // in range
                    if (conversion > base){
                        finalRating += 0.5;
                    }
                    else finalRating -= 0.5;
                }
            }
            if (parabolicSAR == 0){
                finalRating -= 0.5;
            }
            else finalRating += 0.5;
            if (vortexVI == 0){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            finalRating += manual;
        }

        public static void midTerm(){
            if (price20SMA == 0){
                finalRating += 2;
            }
            if (price50SMA == 0){
                finalRating += 4;
            }
            if (price200SMA == 0){
                finalRating += 4;
            }
            if (price8EMA == 0){
                finalRating += 3;
            }
            if (rsi > 70){
                finalRating -= 0.5;
            }
            else if (rsi < 30){
                finalRating += 0.5;
            }
            if (macd > macdSignal){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            if (macd > 0){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            if (adx > 25){
                if (diPlus > diMinus){
                    finalRating += 0.5;
                }
                else finalRating -= 0.5;
            }
            else {
                if (diPlus > diMinus){
                    finalRating += 0.25;
                }
                else finalRating -= 0.25;
            }
            if (aroonUp > aroonDown){
                finalRating += (aroonUp - aroonDown)/100;
            }
            else finalRating -= (aroonDown - aroonUp)/100;
            if (leadingA > leadingB){
                finalRating++;
                if (price > leadingA){ // > range
                    finalRating++;
                    if (conversion > base){
                        finalRating += 2.5;
                    }
                    else finalRating -= 0.5;
                }
                else if (price < leadingB){ // < range
                    finalRating--;
                    if (conversion < base){
                        finalRating -= 2.5;
                    }
                    else finalRating += 0.5;
                }
                else { // in range
                    if (conversion > base){
                        finalRating += 0.5;
                    }
                    else finalRating -= 0.5;
                }
            }
            else {
                finalRating--;
                if (price > leadingB){ // > range
                    finalRating++;
                    if (conversion > base){
                        finalRating += 2.5;
                    }
                    else finalRating -= 0.5;
                }
                else if (price < leadingA){ // < range
                    finalRating--;
                    if (conversion < base){
                        finalRating -= 2.5;
                    }
                    else finalRating += 0.5;
                }
                else { // in range
                    if (conversion > base){
                        finalRating += 0.5;
                    }
                    else finalRating -= 0.5;
                }
            }
            if (parabolicSAR == 0){
                finalRating -= 0.5;
            }
            else finalRating += 0.5;
            if (vortexVI == 0){
                finalRating += 0.5;
            }
            else finalRating -= 0.5;
            finalRating += manual;
        }
        public static void infoCollect(){
            Scanner scanner =  new Scanner(System.in);
            System.out.println("Price > 20 SMA? [0] for true, [1] for false");
            price20SMA = scanner.nextInt();
            while (price20SMA != 0 && price20SMA != 1){
                System.out.println("Enter a valid input.");
                price20SMA = scanner.nextInt();
            }
            System.out.println("Price > 50 SMA? [0] for true, [1] for false");
            price50SMA = scanner.nextInt();
            while (price50SMA != 0 && price50SMA != 1){
                System.out.println("Enter a valid input.");
                price50SMA = scanner.nextInt();
            }
            System.out.println("Price > 200 SMA? [0] for true, [1] for false");
            price200SMA = scanner.nextInt();
            while (price200SMA != 0 && price200SMA != 1){
                System.out.println("Enter a valid input.");
                price200SMA = scanner.nextInt();
            }
            System.out.println("Price > 8 EMA? [0] for true, [1] for false");
            price8EMA = scanner.nextInt();
            while (price8EMA != 0 && price8EMA != 1){
                System.out.println("Enter a valid input.");
                price8EMA = scanner.nextInt();
            }
            System.out.println("RSI value (0-100): ");
            rsi = scanner.nextDouble();
            while (!((rsi >= 0) && (rsi <= 100))){
                System.out.println("Enter a valid input.");
                rsi = scanner.nextDouble();
            }
            System.out.println("MACD line value: ");
            macd = scanner.nextDouble();
            System.out.println("MACD signal line value: ");
            macdSignal = scanner.nextDouble();
            System.out.println("ADX value (0-100): ");
            adx = scanner.nextDouble();
            while (!((adx >= 0) && (adx <= 100))){
                System.out.println("Enter a valid input.");
                adx = scanner.nextDouble();
            }
            System.out.println("DMI DI+ value (0-100): ");
            diPlus = scanner.nextDouble();
            while (!((diPlus >= 0) && (diPlus <= 100))){
                System.out.println("Enter a valid input.");
                diPlus = scanner.nextDouble();
            }
            System.out.println("DMI DI- value (0-100): ");
            diMinus = scanner.nextDouble();
            while (!((diMinus >= 0) && (diMinus <= 100))){
                System.out.println("Enter a valid input.");
                diMinus = scanner.nextDouble();
            }
            System.out.println("Aroon UP value (0-100): ");
            aroonUp = scanner.nextDouble();
            while (!((aroonUp >= 0) && (aroonUp <= 100))){
                System.out.println("Enter a valid input.");
                aroonUp = scanner.nextDouble();
            }
            System.out.println("Aroon DOWN value (0-100): ");
            aroonDown = scanner.nextDouble();
            while (!((aroonDown >= 0) && (aroonDown <= 100))){
                System.out.println("Enter a valid input.");
                aroonDown = scanner.nextDouble();
            }
            System.out.println("Ichimoku Cloud Leading A: ");
            leadingA = scanner.nextDouble();
            System.out.println("Ichimoku Cloud Leading B: ");
            leadingB = scanner.nextDouble();
            System.out.println("Ichimoku Cloud Conversion: ");
            conversion = scanner.nextDouble();
            System.out.println("Ichimoku Cloud Base: ");
            base = scanner.nextDouble();
            System.out.println("Parabolic SAR Dots > Price? [0] for true, [1] for false");
            parabolicSAR = scanner.nextInt();
            while (parabolicSAR != 0 && parabolicSAR != 1){
                System.out.println("Enter a valid input.");
                parabolicSAR = scanner.nextInt();
            }
            System.out.println("Vortex VI+ > Vortex VI-? [0] for true, [1] for false");
            vortexVI = scanner.nextInt();
            while (vortexVI != 0 && vortexVI != 1){
                System.out.println("Enter a valid input.");
                vortexVI = scanner.nextInt();
            }
            System.out.println("Enter Manual Analysis Score (-1 to 1): ");
            manual = scanner.nextDouble();
            while (!((manual >= -1) && (manual <= 1))){
                System.out.println("Enter a valid input.");
                manual = scanner.nextDouble();
            }
        }
    }