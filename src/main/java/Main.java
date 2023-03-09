// dev branch for Y.Practicum

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        AdvancedScanner as = new AdvancedScanner();

        System.out.println("Введите количество человек, на которых необходимо разделить счет:");
        while (true) {

            int qPeople = as.requestInt();
            if (qPeople == 1) {
                System.out.println("Нет смысла делить счет на одного. Повторите ввод:");
            } else if (qPeople < 1) {
                System.out.println("Введено некорректное число человек. Повторите ввод:");
            } else {
                System.out.println("Делим счет на " + qPeople+". Запускаю калькулятор");

                //создаем калькулятор с пустыми начальными значениями
                Calc c1 = new Calc("Добавленные товары:\n", qPeople);

                // запускаем бесконечный цикл запроса данных о товаре
                int i = 1; // номер товара в списке
                while (true) {
                    // запрос наименования товара
                    System.out.println("Введите наименование товара:");
                    String product = as.requestString();

                    // теперь запрос цены товара
                    System.out.println("Введите стоимость товара \""+product+"\" в формате \"рубли.копейки\":");
                    double cost = as.requestDouble();
                    while (true) {  // проверка ввода цены
                        if (cost < 0.1) {
                            System.out.println("Стоимость товара не может быть меньше 1 копейки. Повторите ввод цены:");
                            cost = as.requestDouble();
                        } else {  break; }
                    }

                    c1.add(i + ". " + product, cost); // добавляем товар в калькулятор
                    i++;

                    // предлагаем ввести еще товар или завершить ввод и расчитать
                    System.out.println("Товар успешно добавлен в калькулятор. \nХотите добавить еще один товар? Если нет напишите \"Завершить\"");
                    String userAnswer = as.requestString();
                    if (userAnswer.equalsIgnoreCase("Завершить")) {
                        break;
                    }   // иначе начинаем новую итерацию
                }

                System.out.println("\n" + c1.productName +
                        "Всего на " + String.format("%.2f", c1.productsSum) + " " + getPadejOfRubl(c1.productsSum));

                System.out.println("Каждый из " + qPeople + " человек должен заплатить по: " +
                        String.format("%.2f", c1.sumPerPerson)+ " " + getPadejOfRubl(c1.sumPerPerson));
                break;
            }
        }
    }

    public static String getPadejOfRubl (double sum) {

        int i = (int) Math.floor(sum % 100); // получаем последний символ целой части суммы как число
        if (i >= 11 && i <= 19) { // выбираем правильный падеж Рубля
            return "рублей";
        } else {
            i = (int)Math.floor(sum % 10);
            switch (i) {
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
        }
    }

}

