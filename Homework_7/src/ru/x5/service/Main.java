package ru.x5.service;

import ru.x5.service.accountservice.Account;
import ru.x5.service.accountservice.AccountService;
import ru.x5.service.accountservice.AccountServiceImpl;
import ru.x5.service.dao.DAO;
import ru.x5.service.dao.FilesDAO;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassToManage classToManage = new ClassToManage();
        classToManage.run();
    }
}
