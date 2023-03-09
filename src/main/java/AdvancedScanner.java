import java.util.Scanner;

public class AdvancedScanner {
    Scanner scan = new Scanner(System.in);

    int requestInt () {
        int n;
        while (true) {
             if (scan.hasNextInt()) {
                n = scan.nextInt();
                scan.nextLine();
                break;
            } else {
                System.out.println("Некорректный ввод попробуйте еще раз");
                scan.nextLine();
            }
        }
        return n;
    }

    String requestString () {
        String s;
        while (true) {
            if (scan.hasNextLine()) {
                s = scan.nextLine();
                s = s.trim();
                if (s.isEmpty()) {
                    System.out.println("Вы ввели пустую строку, повторите ввод");
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод попробуйте еще раз");
                scan.nextLine();
            }
        }
        return s;
    }

    double requestDouble () {
        double d;
        while (true) {
            if (scan.hasNextDouble()) {
                d = scan.nextDouble();
                scan.nextLine();
                break;
            } else {
                System.out.println("Некорректный ввод поробуйте еще раз");
                scan.nextLine();
            }
        }
        return d;
    }
}
