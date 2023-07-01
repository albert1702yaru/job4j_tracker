package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банка с клиентами и их счетами
 * @author ALBERT ISMANSKIY
 * @version 1.0
 */
public class BankService {
    /**
     * Данные пользователя и счетов хранятся в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает данные нового пользователя
     * @param user данные пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспорт пользователя
     * и удаляет пользователя по паспорту
     * @param passport идентификатор пользователя в системе
     * @return возращает true при удачном выполнении операции
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает паспот и счет
     * ищит пользователя по паспорту в случае удачи
     * создает пользователю требуемый счет
     * @param passport идентификатор пользователя в системе
     * @param account идентификатор счета пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход папорт
     * и ищет пользователя по паспорту
     * в случае успеха возращает данного пользователя
     * @param passport идентификатор пользователя в системе
     * @return возращает пользователя если пользователь найден
     * и null в противном случае
     */
    public User findByPassport(String passport) {
        for (User i : users.keySet()) {
            if (i.getPassport().equals(passport)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Метод принимает паспорт и счет
     * проверяет существует-ли пользователь с таким паспортом
     * в случае успеха возращает счет после сопоставления счетов
     * пользователя с предьявленным
     * @param passport идентификатор пользователя в системе
     * @param requisite искомый счет
     * @return возращает сопоставленый счет, в противном случае null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }      return findByRequisite(passport, requisite);
        }
        return null;
    }

    /**
     * Метод принимает паспорт пользователя счета от куда будет
     * осуществятся перевод и паспорт 2го пользователя 2го счета
     * куда будет осуществлятся перевод
     * проверяет существуюли оба пользователя и их счета пользователя
     * достаточно ли денег на 1м счете
     * если счета 2го пользователя нет, то содает счет
     * осуществляет перевод с 1го счета на 2й
     * возращает true в случае успеха
     * @param srcPassport идентификатор пользователя 1 в системе
     * @param srcRequisite счет пользователя 1
     * @param destPassport идентификатор пользователя 2 в системе
     * @param destRequisite счет пользователя 2
     * @param amount баланс счета пользователя 1
     * @return возращает true в случае успеха
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
            Account srcAccount = findByRequisite(srcPassport, srcRequisite);
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if (destAccount == null) {
                addAccount(destPassport, new Account(destRequisite, 0D));
                destAccount = findByRequisite(destPassport, destRequisite);
            }
            if (srcAccount != null && srcAccount.getBalance() >= amount) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                return true;
        }
        return false;
    }

    /**
     * Геттер счета пользователя
     * @param user пользователь
     * @return счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}