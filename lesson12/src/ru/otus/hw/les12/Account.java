package ru.otus.hw.les12;

import java.util.Objects;
import java.util.UUID;

/**
 * Банковский счет
 */
public class Account {
    private final Client accountOwner;
    private int goldCoins;

    //Счёт по условиям ДЗ не имеет идентифицирующего свойства
    //поэтому решил добавить номер счета (UUID, String, Int) - для ДЗ не принципиально
    private final UUID num;

    /**
     * Создать счет
     *
     * @param num          номер счета
     * @param accountOwner владелец счета
     */
    private Account(UUID num, Client accountOwner) {
        this.accountOwner = accountOwner;
        this.num = num;
        accountOwner.getAccounts().add(this);
    }

    /**
     * Создать счёт с автосгенерированным номером
     *
     * @param accountOwner владелец счета
     * @return Новый счет
     */
    public static Account createAccountWithAutogeneratedNum(Client accountOwner) {
        var num = UUID.randomUUID();
        return new Account(num, accountOwner);
    }

    /**
     * Получить владельца счета
     *
     * @return владелец счета
     */
    public Client getAccountOwner() {
        return accountOwner;
    }

    /**
     * Получить номер счета
     *
     * @return номер счета
     */
    public UUID getNum() {
        return num;
    }

    /**
     * Получить количество золотых монет
     *
     * @return количество золотых монет
     */
    public int getGoldCoins() {
        return goldCoins;
    }

    /**
     * Установить количество золотых монет
     *
     * @param goldCoins количество золотых монет
     */
    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return num.equals(account.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "Account{" +
                "num=" + num +
                ", client=" + (accountOwner != null ? accountOwner.getId() : "") +
                ", goldCoins=" + goldCoins +
                '}';
    }
}
