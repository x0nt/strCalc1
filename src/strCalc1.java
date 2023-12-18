import java.util.Scanner;

public class strCalc1 {
    public static void main(String[] args) throws Exception {
        Scanner a = new Scanner(System.in);
        String input = a.nextLine();
        input = input.replace(" \" ", "");
        String[] operands;
        char under;
        if (input.contains(" + ")) {
            operands = input.split(" \\+ ");
            if (!operands[0].startsWith("\"") || !operands[0].endsWith("\""))
                throw new Exception("Слова должны быть в кавычках");
            if (!operands[1].startsWith("\"") || !operands[1].endsWith("\""))
                throw new Exception("Слова должны быть в кавычках");
            under = '+';
        } else if (input.contains(" - ")) {
            operands = input.split(" - ");
            if (!operands[0].startsWith("\"") || !operands[0].endsWith("\""))
                throw new Exception("Слова должны быть в кавычках");
            if (!operands[1].startsWith("\"") || !operands[1].endsWith("\""))
                throw new Exception("Слова должны быть в кавычках");
            under = '-';
        } else if (input.contains(" * ")) {
            operands = input.split(" \\* ");
            under = '*';
        } else if (input.contains(" / ")) {
            operands = input.split(" / ");
            under = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (operands[0].length() > 10 || operands[1].length() > 10) {
            throw new Exception("Недопустимое количество символов");
        }
        if (under == '*' || under == '/') {
            if (operands[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < operands.length; i++) {
            operands[i] = operands[i].replace("\"", "");
        }
        String result;
        if (under == '+') {
            System.out.println(printInQuotes(operands[0] + operands[1]));
        } else if (under == '*') {
            int num = Integer.parseInt(operands[1]);
            if (num < 1 || num > 10) {
                throw new Exception("Вводимое число должно быть от 1 до 10");
            }
            result = "";
            for (int i = 0; i < num; i++) {
                result += operands[0];
            }
            System.out.println(printInQuotes(result));
        } else if (under == '/') {
            int num = Integer.parseInt(operands[1]);
            if (num < 1 || num > 10) {
                throw new Exception("Вводимое число должно быть от 1 до 10");
            }
            int division = operands[0].length() / Integer.parseInt(operands[1]);
            result = operands[0].substring(0, division);
            System.out.println(printInQuotes(result));
        } else if (under == '-') {
            int index = operands[0].indexOf(operands[1]);
            if (index == -1) {
                System.out.println(printInQuotes(operands[0]));
            } else {
                result = operands[0].substring(0, index);
                result += operands[0].substring(index + operands[1].length());
                System.out.println(printInQuotes(result));
            }
        }
    }

    static String printInQuotes(String text) {
        if (text.length() > 40) {
            text = text.substring(0, 40) + "...";
        }
        return "\"" + text + "\"";
    }
}