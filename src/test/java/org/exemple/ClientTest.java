package org.exemple;

import org.exemle.accounts.CheckingAccount;
import org.exemle.accounts.CreditAccount;
import org.exemle.accounts.SavingsAccount;
import org.exemle.clients.Client;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование: Client")

public class ClientTest {


    @Test
    @DisplayName("Превышение лимита счетов")
    void addAccount() {
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            Client client = new Client("Petya", 3);

            SavingsAccount savingsAccount = new SavingsAccount("Petya", 53000, 3000);
            CheckingAccount checkingAccount = new CheckingAccount("Petya", 100000);
            CreditAccount creditAccount = new CreditAccount("Petya");
            CreditAccount creditAccount1 = new CreditAccount("Pavel");

            client.add(savingsAccount);
            client.add(checkingAccount);
            client.add(creditAccount);
            client.add(creditAccount1);

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Вы не можете больше добавлять счета!\r\n", consoleOutput);
    }

    @Test
    @DisplayName("Платёж с накопительного счёта")
    void paySavingsAccount() {
        Client client = new Client("Petya", 1);
        SavingsAccount savingsAccount = new SavingsAccount("Petya", 53000, 3000);
        client.add(savingsAccount);
        assertTrue(client.pay(50000));
    }

    @Test
    @DisplayName("Перевод средств между счетами")
    void transferTest() {

        SavingsAccount savingsAccount = new SavingsAccount("Petya", 3000, 3000);
        CheckingAccount checkingAccount = new CheckingAccount("Petya", 100000);
        assertFalse(savingsAccount.transfer(checkingAccount, 1000));
    }
}
