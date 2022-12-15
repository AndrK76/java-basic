package ru.otus.hw.les08;

/**
 * Вопрос теста
 */
public class Question {
    private String query;
    private String[] answerOptions;
    private int validOptionNumber;

    /**
     * Создать вопрос теста
     * @param text Текст вопроса
     * @param answerOptions Варианты ответа
     * @param validOptionIndex Номер правильного варианта (нумерация с 1)
     */
    public Question(String text, String[] answerOptions, int validOptionIndex) {
        this.query = text;
        this.answerOptions = answerOptions;
        this.validOptionNumber = validOptionIndex;
    }

    /**
     * Получить текст запроса
     * @return Текст запроса
     */
    public String getQuery() {
        return query;
    }

    /**
     * Получить правильный номер ответа
     * @return Правильный номер ответа
     */
    public int getValidOptionNumber() {
        return validOptionNumber;
    }

    /**
     * Получить список вариантов ответа
     * @return Варианты ответа
     */
    public String[] getAnswerOptions() {
        return answerOptions;
    }
}
