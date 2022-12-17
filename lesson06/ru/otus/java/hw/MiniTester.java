package ru.otus.java.hw;

import java.util.Scanner;

/**
 * ДЗ "Система тестирования". Итерация 1
 */
public class MiniTester {
    public static void main(String[] args) {
        // Переменные для хранения количества правильных и неправильных ответов
        int correctCount = 0, wrongCount = 0;

        //Массив вопросов
        String[] questions = {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?",
        };
        //Массив вариантов ответов
        String[][] answerOptions = {
                {"cs", "java", "class", "exe"},
                {"commit", "push", "clone", "copy"},
                {"while", "for", "loop"},
        };
        //Массив правильных ответов
        int[] correctAnswers = {2, 2, 0};

        Scanner scanner = new Scanner(System.in);
        //Цикл по всем вопросам
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Вопрос №" + (i + 1) + ":");
            System.out.println(questions[i]);
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println((j + 1) + ". " + answerOptions[i][j]);
            }
            System.out.print("Ваш ответ: ");
            int answer = scanner.nextInt();
            if (answer == correctAnswers[i]+1){
                System.out.println("Правильно");
                correctCount++;
            }
            else {
                System.out.println("Неправильно");
                wrongCount++;
            }
            System.out.println();
        }
        //Выводим общий результат
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
}
