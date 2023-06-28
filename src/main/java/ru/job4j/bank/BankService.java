package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        boolean flag = true;
        if (findByPassport(passport) != null) {
            for (Account i : users.get(new User(passport, ""))) {
                if (account.getRequisite().equals(i.getRequisite())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                users.get(new User(passport, "")).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User i : users.keySet()) {
            if (i.getPassport().equals(passport)) {
                return i;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account account : users.get(new User(passport, ""))) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account regSrc = findByRequisite(srcPassport, srcRequisite);
        if (regSrc != null && regSrc.getBalance() >= amount) {
            regSrc.setBalance(regSrc.getBalance() - amount);
            Account regDest = findByRequisite(destPassport, destRequisite);
            if (regDest == null) {
                addAccount(destPassport, new Account(destRequisite, 0D));
                regDest = findByRequisite(destPassport, destRequisite);
            }
            regDest.setBalance(regDest.getBalance() + amount);
            return true;
        }
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}