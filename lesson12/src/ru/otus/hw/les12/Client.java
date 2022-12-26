package ru.otus.hw.les12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

/**
 * Клиент банка
 */
public class Client {
    private final String name;
    private final int age;

    private final UUID id;

    private final ArrayList<Account> accounts;

    /**
     * Создать клиента
     * @param name Имя клиента
     * @param age Возраст клиента
     */
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
        this.accounts = new ArrayList<>();
    }

    /**
     * Получить Id клиента
     * @return Id клиента
     */
    public UUID getId() {
        return id;
    }

    /**
     * Получить имя клиента
     * @return имя клиента
     */
    public String getName() {
        return name;
    }

    /**
     * Получить возраст клиента
     * @return возраст клиента
     */
    public int getAge() {
        return age;
    }

    /**
     * Получить список счетов
     * @return счета клиента
     */
    public Collection<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder accountsStr = new StringBuilder();
        for (var account : getAccounts()) {
            accountsStr.append(", ").append(account);
        }
        if (!accountsStr.toString().equalsIgnoreCase("")) {
            accountsStr = new StringBuilder("{" + accountsStr.substring(2) + "}");
        }
        return "Client{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", id=" + getId() +
                ", accounts={" + accountsStr +
                "}}";
    }
}
