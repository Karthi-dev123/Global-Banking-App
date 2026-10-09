
public class TestAccountEnhanced {

    // Display account details
    public static void displayAccount(AccountEnhanced account) {
        System.out.println(
            "Account #" + account.getAccountNumber()
            + " | " + account.getName()
            + " (" + account.getAge() + " yrs)"
            + " | " + account.getAccountType()
            + " | ₹" + account.getBalance()
            + " | " + account.getStatus()
            + " | PIN: " + (account.hasPin() ? "Yes" : "No")
        );
    }

    // Display success or failure using boolean return values
    public static void displayResult(String operation, boolean result) {
        System.out.println(operation + ": "
            + (result ? "SUCCESS" : "FAILED"));
    }

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println(" ENHANCED ACCOUNT TEST (BOOLEAN RETURNS)");
        System.out.println("============================================================");

        // Test 1: Valid Account Creation
        System.out.println("\n>>> Test 1: Valid Account Creation");

        AccountEnhanced a1 = new AccountEnhanced(
            1001, "John Doe", 25, 1000.0, "Savings"
        );

        displayAccount(a1);

        // Test 2: Invalid Age
        System.out.println("\n>>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");

        AccountEnhanced a2 = new AccountEnhanced(
            1002, "Young Kid", 16, 300.0, "Savings"
        );

        System.out.println("Age auto-corrected to: " + a2.getAge());
        displayAccount(a2);

        // Test 3: Invalid Account Type
        System.out.println("\n>>> Test 3: Invalid Account Type");
        System.out.println("Creating account with type \"Invalid\"");

        AccountEnhanced a3 = new AccountEnhanced(
            1003, "Test User", 25, 300.0, "Invalid"
        );

        System.out.println("Account type defaulted to: "
            + a3.getAccountType());
        displayAccount(a3);

        // Test 4: Minimum Balance Enforcement on Creation
        System.out.println("\n>>> Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with ₹300 (below minimum)");

        AccountEnhanced a4 = new AccountEnhanced(
            1004, "Bob Wilson", 25, 300.0, "Savings"
        );

        System.out.println("Balance auto-corrected to minimum: ₹"
            + a4.getBalance());
        displayAccount(a4);

        // Test 5: Withdrawal with Minimum Balance
        System.out.println("\n>>> Test 5: Withdrawal with Minimum Balance");

        AccountEnhanced a5 = new AccountEnhanced(
            1005, "Alice Brown", 30, 1500.0, "Current"
        );

        a5.setPin(1234);
        System.out.print("Initial: ");
        displayAccount(a5);

        boolean withdrawal1 = a5.withdraw(200.0, 1234);
        displayResult("Withdrawing ₹200.0", withdrawal1);
        System.out.println("New balance: ₹" + a5.getBalance());

        System.out.print("After withdrawal: ");
        displayAccount(a5);

        boolean withdrawal2 = a5.withdraw(900.0, 1234);
        System.out.println(
            "Withdrawing ₹900.0 (would leave ₹-100): "
            + (withdrawal2
                ? "SUCCESS"
                : "FAILED (Minimum balance violation)")
        );

        System.out.println("Current balance: ₹" + a5.getBalance());

        // Test 6: Account Status Management
        System.out.println("\n>>> Test 6: Account Status Management");

        AccountEnhanced a6 = new AccountEnhanced(
            1006, "Charlie Green", 35, 2000.0, "Savings"
        );

        System.out.print("Initial: ");
        displayAccount(a6);

        displayResult("Closing account", a6.closeAccount());

        System.out.print("After close: ");
        displayAccount(a6);

        boolean depositResult = a6.deposit(500.0);

        System.out.println(
            "Depositing ₹500.0 to closed account: "
            + (depositResult
                ? "SUCCESS"
                : "FAILED (Account inactive)")
        );

        displayResult("Reopening account", a6.reopenAccount());

        System.out.print("After reopen: ");
        displayAccount(a6);

        // Test 7: PIN Protection
        System.out.println("\n>>> Test 7: PIN Protection");

        AccountEnhanced a7 = new AccountEnhanced(
            1007, "Diana Prince", 28, 1500.0, "Savings"
        );

        displayResult("Setting PIN 1234", a7.setPin(1234));

        boolean correctPin = a7.withdraw(200.0, 1234);

        System.out.println(
            "Withdrawing ₹200.0 with correct PIN (1234): "
            + (correctPin ? "SUCCESS" : "FAILED")
        );

        System.out.println("New balance: ₹" + a7.getBalance());

        boolean incorrectPin = a7.withdraw(100.0, 9999);

        System.out.println(
            "Withdrawing ₹100.0 with incorrect PIN (9999): "
            + (incorrectPin
                ? "SUCCESS"
                : "FAILED (Incorrect PIN)")
        );

        AccountEnhanced a8 = new AccountEnhanced(
            1008, "PIN Not Set User", 25, 1500.0, "Savings"
        );

        boolean noPin = a8.withdraw(100.0, 1234);

        System.out.println(
            "Withdrawing ₹100.0 with PIN not set: "
            + (noPin
                ? "SUCCESS"
                : "FAILED (PIN not set)")
        );

        // Test 8: All Accounts Summary
        System.out.println("\n>>> Test 8: All Accounts Summary");

        displayAccount(a1);
        displayAccount(a2);
        displayAccount(a3);
        displayAccount(a4);
        displayAccount(a5);
        displayAccount(a6);
        displayAccount(a7);

        System.out.println("============================================================");
        System.out.println(" ENHANCED TEST COMPLETED!");
        System.out.println("============================================================");
    }
}
