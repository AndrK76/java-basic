package ru.otus.hw.les12;

import java.util.*;

/**
 * Банк
 */
public class Bank {
    //Можно было HashMap<Client,Client>
    //В C# использовал бы скорее всего Dictionary<UUID,Client> либо при работе с БД List<Client>
    //В PL*SQL что-то типа Table of Что-то index by varchar2(20) - при условии что нужна работа в памяти а не с таблицами
    private final HashMap<UUID,Client> clients;
    private final HashMap<UUID,Account> accounts;

    /**
     * Создать банк
     */
    public Bank() {
        clients = new HashMap<>();
        accounts = new HashMap<>();
    }

    /**
     * Получить список клиентов в банке
     *
     * @return Список всех клиентов банка
     */
    public Collection<Client> getClients() {
        return clients.values();
    }

    /**
     * Получить список всех счетов в банке
     *
     * @return Полный список счетов в банке
     */
    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    /**
     * Добавить клиента в банк
     *
     * @param client добавляемый клиент
     * @return добавленный клиент
     */
    public Client addClient(Client client) {
        if (clients.containsKey(client)) {
            throw new IllegalArgumentException("Клиент с Id=" + client.getId() + " уже есть");
        }
        clients.put(client.getId(), client);
        return client;
    }

    /**
     * Добавить новый счёт
     *
     * @param account добавляемый счет
     * @return добавленный счет
     */
    public Account addAccount(Account account) {
        accounts.put(account.getNum(), account);
        return account;
    }

    /**
     * Найти счёт по номеру
     * @param num номер счета
     * @return счёт в банке
     */
    public Account findAccountByNum(UUID num)
    {
        return accounts.get(num);
    }

    /**
     * Найти все счета клиента
     *
     * @param client Клиент
     * @return Список счетов клиента
     */
    public Collection<Account> findAccountsByClient(Client client) {
        var thisClient = clients.get(client.getId());
        if (thisClient == null) {
            return null;
        }
        return thisClient.getAccounts();
    }

    /**
     * Найти клиента по имени
     * @param name имя клиента
     * @return Клиент
     */
    public Client findClientByName(String name) {
        for (var client : getClients()) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Найти клиента по счёту
     *
     * @param account счёт для которого ищем клиента
     * @return Владелец счета
     */
    public Client findClientByAccount(Account account) {
        var thisAccount = accounts.get(account.getNum());
        if (thisAccount == null) {
            return null;
        }
        return thisAccount.getAccountOwner();
    }

    /**
     * Показать список счетов в банке
     */
    public void showAccounts() {
        System.out.println("Accounts:");
        for (var account : getAccounts()) {
            System.out.println(account);
        }
    }

    /**
     * Показать список клиентов
     */
    public void showClients() {
        System.out.println("Clients:");
        for (var client : getClients()) {
            System.out.println(client);
        }
    }


}
