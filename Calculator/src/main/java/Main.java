import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] splitted = input.split(" ");
        if (splitted.length != 3 ) {
            throw new Exception(" Неподходящий формат математической операции ");
        }
        int first;
        int second;
        try {
            if ((splitted[0].contains("X") || splitted[0].contains("V") || splitted[0].contains("I")) &&
                    (splitted[2].contains("X") || splitted[2].contains("V") || splitted[2].contains("I"))) {
                first = rimToArabian(splitted[0]);
                second = rimToArabian(splitted[2]);

            } else {
                first = Integer.parseInt(splitted[0]);
                second = Integer.parseInt(splitted[2]);
            }
        } catch (NumberFormatException n) {
            throw new Exception(" Неподходящий формат математической операции ");
        }
        if (first > 10 || second > 10 || first < 1 || second < 1) {
            throw new Exception(" Введите числа от 1 до 10 включительно ");
        }
        int answer;

        switch (splitted[1]) {
            case "+" -> answer = first + second;
            case "-" -> answer = first - second;
            case "*" -> answer = first * second;
            case "/" -> answer = first / second;
            default -> throw new Exception(" Неподходящий формат математической операции ");
        };

        String answerString;
        if (splitted[0].contains("X") || splitted[0].contains("V") || splitted[0].contains("I")) {
            answerString = arabianToRim(answer);
        } else {
            answerString = String.valueOf(answer);
        }
        return answerString;
    }

    public static Integer rimToArabian(String rimskie) throws Exception {
        int number = 0;

            switch (rimskie) {
                case "I" -> number = 1;
                case "II" -> number = 2;
                case "III" -> number = 3;
                case "IV" -> number = 4;
                case "V" -> number = 5;
                case "VI" -> number = 6;
                case "VII" -> number = 7;
                case "VIII" -> number = 8;
                case "IX" -> number = 9;
                case "X" -> number = 10;
                default -> throw new Exception(" Введены неподходящие числа ");
            }
        return number;
    }

    public static String arabianToRim(Integer arabian) throws Exception {
        String number = "";
        if (arabian < 0) {
            throw new Exception("  в римской системе нет отрицательных чисел ");
        }
        if (arabian == 0) {
            throw new Exception(" В римской системе нет нуля ");
        }
        while (arabian > 0 ) {
            if (arabian >= 100) {
                number = number + "C";
                arabian -= 100;
            }
            else if (arabian >= 90) {
                number = number + "XC";
                arabian -= 90;
            }
            else if (arabian >= 50) {
                number = number + "L";
                arabian -= 50;
            }
            else if (arabian >= 40) {
                number = number + "XL";
                arabian -= 40;
            }
            else if (arabian >= 10) {
                number = number + "X";
                arabian -= 10;
            }
            else if (arabian >= 9) {
                number = number + "IX";
                arabian -= 9;
            }
            else if (arabian >= 5) {
                number = number + "V";
                arabian -= 5;
            }
            else if (arabian >= 4) {
                number = number + "IV";
                arabian -= 4;
            }
            else if (arabian >= 1) {
                number = number + "I";
                arabian -= 1;
            }
        }
        return number;
    }
}
