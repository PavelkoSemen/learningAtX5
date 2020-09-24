package ru.x5.service.accountservice;

import ru.x5.service.dao.DAO;
import ru.x5.service.myexception.NotEnoughMoneyException;
import ru.x5.service.myexception.UnknownAccountException;

public interface AccountService {

    void withdraw(int accountId, double amount) throws NotEnoughMoneyException, UnknownAccountException;

    void balance(int accountId) throws UnknownAccountException;

    void deposit(int accountId, double amount) throws NotEnoughMoneyException, UnknownAccountException;

    void transfer(int from, int to, double amount) throws NotEnoughMoneyException, UnknownAccountException;

    void setAccountDAO(DAO<Account> accountDAO);
}
