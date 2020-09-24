package ru.x5.service.accountservice;

import ru.x5.service.dao.DAO;
import ru.x5.service.dao.FilesDAO;
import ru.x5.service.myexception.NotEnoughMoneyException;
import ru.x5.service.myexception.UnknownAccountException;

public class AccountServiceImpl implements AccountService {

    private DAO<Account> accountDAO;

    public AccountServiceImpl(DAO<Account> accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountServiceImpl() {
        this(new FilesDAO());
    }

    @Override
    public void withdraw(int accountId, double amount) throws NotEnoughMoneyException, UnknownAccountException {
        Account account = accountDAO.get(accountId);
        if (account == null) {
            throw new UnknownAccountException("This account does not exist");
        }
        double newAmount = account.getAmount() - amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        account.setAmount(newAmount);
        accountDAO.update(account);
    }

    @Override
    public void balance(int accountId) throws UnknownAccountException {
        Account account = accountDAO.get(accountId);
        if (account == null) {
            throw new UnknownAccountException("This account does not exist");
        }
        System.out.println(account.getAmount());
    }

    @Override
    public void deposit(int accountId, double amount) throws UnknownAccountException {
        Account account = accountDAO.get(accountId);
        if (account == null) {
            throw new UnknownAccountException("This account does not exist");
        }
        double newAmount = account.getAmount() + amount;
        account.setAmount(newAmount);

        accountDAO.update(account);
    }

    @Override
    public void transfer(int from, int to, double amount) throws NotEnoughMoneyException, UnknownAccountException {
        Account accountFromWhich = accountDAO.get(from);
        Account accountForWhich = accountDAO.get(to);

        if (accountForWhich == null && accountFromWhich == null) {
            throw new UnknownAccountException("This accounts does not exist");
        }
        this.withdraw(accountFromWhich.getId(), amount);
        this.deposit(accountForWhich.getId(), amount);
    }

    public void setAccountDAO(DAO<Account> accountDAO) {
        this.accountDAO = accountDAO;
    }
}
