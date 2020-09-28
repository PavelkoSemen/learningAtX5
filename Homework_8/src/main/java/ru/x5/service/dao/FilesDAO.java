package ru.x5.service.dao;

import ru.x5.service.accountservice.Account;
import ru.x5.service.myexception.ExistingAccountException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesDAO implements DAO<Account> {

    private final File DBFile;
    private String separator = "☮";

    public FilesDAO(File DBFile) {
        this.DBFile = DBFile;
        if (isEmptyFile()) {
            createBaseFile();
        }
    }

    public FilesDAO() {
        this(new File("Homework_7/resources/DBFiles.txt"));
    }

    @Override
    public Account get(int id) {
        try (var reader = new BufferedReader(new FileReader(DBFile))) {
            String currentRecording;
            String[] accountParameter;
            Account account = null;
            while ((currentRecording = reader.readLine()) != null) {
                if (currentRecording.startsWith(id + separator)) {
                    break;
                }
            }
            if (currentRecording != null) {
                accountParameter = currentRecording.split(separator);
                account = new Account(
                        Integer.parseInt(accountParameter[0]),
                        accountParameter[1],
                        Double.parseDouble(accountParameter[2])
                );
            }
            return account;
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public void save(Account account) {
        String currentRecording = account.getId() + separator + account.getHolder() + separator + account.getAmount();
        try (var writer = new PrintWriter(new FileWriter(DBFile, true))) {
            if (isFileContains(account.getId())) {
                throw new ExistingAccountException("Account already exists");
            }
            writer.println(currentRecording);
            writer.flush();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Account account) {
        if (isFileContains(account.getId())) {
            this.delete(account);
            this.save(account);
        }
    }

    @Override
    public void delete(Account account) {

        String deleteRecordingID = account.getId() + separator;
        List<String> recordingList = new ArrayList<>();

        try (var reader = new BufferedReader(new FileReader(DBFile))) {
            String currentRecording;
            while ((currentRecording = reader.readLine()) != null) {
                if (!currentRecording.startsWith(deleteRecordingID)) {
                    recordingList.add(currentRecording);
                }
            }
            updateFile(recordingList);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private boolean isEmptyFile() {
        boolean isEmpty = DBFile.length() != 0;

        if (DBFile.exists() && isEmpty) {
            return false;
        }
        return true;
    }

    private void createBaseFile() {
        try (var writer = new PrintWriter(new FileWriter(DBFile))) {
            int baseLineCount = 10;
            String holder;
            double amount;
            for (int i = 0; i < baseLineCount; i++) {
                holder = "holder_" + i;
                amount = (i + 1) * 1000;
                writer.println(i + separator + holder + separator + amount);
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void updateFile(List<String> accountList) {
        String path = DBFile.getAbsolutePath();

        DBFile.delete();
        File newFile = new File(path);

        try (var writer = new PrintWriter(new FileWriter(newFile))) {
            for (String currentRecording : accountList) {
                writer.println(currentRecording);
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private boolean isFileContains(int id) {
        boolean isContains = false;
        String recordingID = id + separator;
        try (var reader = new BufferedReader(new FileReader(DBFile))) {

            String currentRecording;
            while ((currentRecording = reader.readLine()) != null) {
                if (currentRecording.startsWith(recordingID)) {
                    isContains = true;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return isContains;
    }
}
