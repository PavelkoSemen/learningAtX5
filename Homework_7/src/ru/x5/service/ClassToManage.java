package ru.x5.service;


import ru.x5.service.accountservice.Account;
import ru.x5.service.accountservice.AccountService;
import ru.x5.service.accountservice.AccountServiceImpl;
import ru.x5.service.dao.DAO;
import ru.x5.service.myexception.ExistingAccountException;
import ru.x5.service.myexception.NotEnoughMoneyException;
import ru.x5.service.myexception.UnknownAccountException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ClassToManage {
    private AccountService accountService = new AccountServiceImpl();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Commands command = null;
        this.info();
        do {
            try {
                command = Commands.valueOf(scanner.next().toUpperCase());
                switchCommand(scanner, command);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Неверная команда");
            }
        } while (command != Commands.EXIT);
    }

    private void info() {
        Path pathInfoFile = Path.of("Homework_7", "resources", "info.txt");
        Charset charset = Charset.forName("UTF-8");
        try {
            System.out.println("INFO:");
            System.out.println(new String(Files.readAllBytes(pathInfoFile), charset));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchCommand(Scanner scanner, Commands command) {
        try {
            switch (command) {
                case BALANCE:
                    accountService.balance(scanner.nextInt());
                    break;
                case DEPOSIT:
                    accountService.deposit(scanner.nextInt(), scanner.nextDouble());
                    break;
                case WITHDRAW:
                    accountService.withdraw(scanner.nextInt(), scanner.nextDouble());
                    break;
                case TRANSFER:
                    accountService.transfer(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case EXIT:
                    System.out.println("Пока!");
                default:
                    System.err.println("НЕИЗВЕСТНАЯ КОМАНДА");
            }
        } catch (ExistingAccountException | NotEnoughMoneyException | UnknownAccountException e) {
            System.err.println("Ошибка параметров аккаунта " + e);
        } catch (RuntimeException e) {
            System.err.println(e);
        }
    }

    public void setDAO(DAO<Account> accountDAO) {
        accountService.setAccountDAO(accountDAO);
    }

    public enum Commands {
        BALANCE, WITHDRAW, DEPOSIT, TRANSFER, EXIT;
    }
}
