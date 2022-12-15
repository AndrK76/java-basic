package ru.otus.hw.les08;

import java.util.Scanner;

/**
 * Простой тест
 */
public class Tester {

    private Question[] questions;

    /**
     * Создать экземпляр теста
     */
    public Tester() {
        questions = new Question[]{
                new Question("В файл с каким расширением компилируется java-файл?",
                        new String[]{"cs", "java", "class", "exe"},
                        3),
                new Question("С помощью какой команды git можно получить полную копию удаленного репозитория?",
                        new String[]{"commit", "push", "clone", "copy"},
                        3),
                new Question("Какой применяется цикл, когда не известно количество итераций?",
                        new String[]{"while", "for", "loop"},
                        1),
        };
    }

    private int correctCount = 0;
    private int wrongCount = 0;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Запустить тест
     */
    public void runTest() {
        correctCount = 0;
        wrongCount = 0;
        for (var question : questions) {
            System.out.printf("Вопрос:\n\t%s\n", question.getQuery());
            System.out.printf("Варианты ответа:\n");
            for (int i = 0; i < question.getAnswerOptions().length; i++) {
                System.out.printf("\t%d.%s\n", (i + 1), question.getAnswerOptions()[i]);
            }
            System.out.printf("Ваш вариант: ");
            int answer = scanner.nextInt();
            if (answer == question.getValidOptionNumber()) {
                System.out.printf("\t\tПравильно\n");
                correctCount++;
            } else {
                System.out.printf("\t\tНе правильно\n");
                wrongCount++;
            }
            System.out.println();
        }
    }

    /**
     * Получить результат последнего прохождения теста
     */
    public void showLastRunTestResults() {
        System.out.printf("\nРезультат: правильно: %d\tнеправильно: %d\n", correctCount, wrongCount);
    }

}


