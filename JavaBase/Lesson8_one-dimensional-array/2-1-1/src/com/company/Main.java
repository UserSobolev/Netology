package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Создаем массив products[] и заполняем его экземплярами класса Product + заполняем поля
        Product[] products = new Product[] {
                new Product("Хлеб", 14, 1),
                new Product("Молоко", 50, 2),
                new Product("Сыр", 130, 3),
                new Product("Яйца", 80, 4),
        };
//Выводим все эллементы массива на экран
        //System.out.println(Arrays.toString(products));
        for (Product product : products) {
            System.out.println(product.toString());
        }

        while (true) {
            System.out.println("Введите номер товара и количество или 'end'");
//берем строку, введенную пользователем, и проверяем хочет ли пользователь завершить работу программы
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
//делим введенную строку по пробелам, считаем количество единиц каждого из товаров
            String[] mass = input.split(" ");
            int number = Integer.parseInt(mass[0]) - 1;
            int qty = Integer.parseInt(mass[1]);
            products[number].qty += qty;
        }

        System.out.println("Ваша корзина: \n" + "Наименование товара  Количество товара   Цена/за ед.   Общая стоимость");

        int totalSum = 0;
//не понимаю как сделать выравнивание через printf
        for (Product product : products) {
            if (product.qty > 0) {
                System.out.println(product.title + "\t" + product.qty + "\t" + product.price + "\t" + product.qty * product.price);
                totalSum += product.qty * product.price;
            }
        }
        System.out.println("Итог " + "\t" + totalSum);
    }
}
