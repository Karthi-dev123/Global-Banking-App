public class TestAccount {
    public static void main(String[] args) {
        Account acc1 = new Account(1001,"John Doe", 25, 1000.0, "Savings");
        //1st successful case - money deposit of 500, balance 1500
        //failed case - money deposit of -100
        boolean action1 = acc1.deposit(500);
        if(action1 == true) {
            System.out.println("Balance:"+acc1.getBalance());
            System.out.println("SUCCESS");
        }
        else {
            System.out.println("deposit failed");
        }
        boolean action2 = acc1.deposit(-100);
        if(action2 == true) {
            System.out.println("Balance:"+acc1.getBalance());
            System.out.println("SUCCESS");
        }
        else {
            System.out.println("deposit failed");
        }
        //withdrawal - 200 - success, -balance 1300,
        boolean action3 = acc1.withdraw(200);
        if(action3 == true) {
            System.out.println("Withdrawn amount"+ 200);
            System.out.println("balance:"+acc1.getBalance());
            System.out.println("SUCCESS");
        }
        else {
            System.out.println("Failed: Insufficient balance");
            System.out.println("Balance:"+acc1.getBalance());
        }
        boolean action4 = acc1.withdraw(2000);
        if(action4 == true) {
            System.out.println("Withdrawn amount"+ 2000);
            System.out.println("balance:"+acc1.getBalance());
            System.out.println("SUCCESS");
        }
        else {
            System.out.println("Failed: Insufficient balance");
            System.out.println("Balance:"+acc1.getBalance());
        }
        Account acc2 = new Account(1002,"Jane Smith",30, 2000.0, "Savings");
        //print the account info
        //Account #1001 | John Doe (25 yrs) | Savings | ₹1300.0 | Active
        //Account #1002 | Jane Smith (30 yrs) | Current | ₹2000.0 | Active
        System.out.println(String.format("Account#%d | %s (%d yrs) | %s | ₹%.2f | %s",acc1.getAccountNumber(),acc1.getName(),
        acc1.getAge(),acc1.getAccountType(), acc1.getBalance(), acc1.getStatus()));


    }
}