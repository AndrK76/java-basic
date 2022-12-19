package ru.otus.hw.les12;

import java.util.UUID;

public class Lesson12 {
    public static void main(String[] args) {
        var bank = initBank();

        bank.showClients();
        System.out.println();
        bank.showAccounts();

        testFindAccountsByClient(bank);
        testFindClientByAccount(bank);
    }

    private static void testFindClientByAccount(Bank bank) {
        System.out.println();
        System.out.println("Get Client by account");
        for (var num : new UUID[]{bank.getAccounts().stream().toList().get(0).getNum(), UUID.randomUUID()}) {
            var account = bank.findAccountByNum(num);
            if (account != null) {
                System.out.printf("Account:\t{num=%s, goldCoins=%d}\n", account.getNum(), account.getGoldCoins());
                var client = bank.findClientByAccount(account);
                System.out.printf("\tFound: %s\n", client);
            } else {
                System.out.print("Account:\t{null}\n");
            }
        }
    }

    private static void testFindAccountsByClient(Bank bank) {
        System.out.println();
        System.out.println("Get Accounts by client");
        for (var name : new String[]{"петров", "пушкин"}) {
            var client = bank.findClientByName(name);
            if (client != null) {
                System.out.printf("Client:\t{id=%s, name=%s} accounts:\n", client.getId(), client.getName());
                for (var account : bank.findAccountsByClient(client)) {
                    System.out.printf("\t %s\n", account);
                }
            } else {
                System.out.print("Client:\t{null}\n");
            }

        }
    }

    static Bank initBank() {
        Bank bank = new Bank();
        var client = bank.addClient(Client.createClientWithAutogeneratedId("Иванов", 20));
        var account = bank.addAccount(Account.createAccountWithAutogeneratedNum(client));
        account.setGoldCoins(5);
        account = bank.addAccount(Account.createAccountWithAutogeneratedNum(client));
        account.setGoldCoins(12);

        client = bank.addClient(Client.createClientWithAutogeneratedId("Петров", 45));
        account = bank.addAccount(Account.createAccountWithAutogeneratedNum(client));
        account.setGoldCoins(15);
        account = bank.addAccount(Account.createAccountWithAutogeneratedNum(client));
        account.setGoldCoins(33);
        account = bank.addAccount(Account.createAccountWithAutogeneratedNum(client));
        account.setGoldCoins(33);
        return bank;
    }
}
