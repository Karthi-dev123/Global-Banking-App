public class Account {
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status ;

    // version 1 ( accepts status)
    // **MISTAKE ** 
    // public Account(int accountNumber, 
    //                 String name, 
    //                 int age, 
    //                 double balance,
    //                 String accountType,
    //                 String status ){


    //     this.accountNumber = accountNumber;
    //     this.name = name;
    //     this.age = age;
    //     this.balance = balance;
    //     this.accountType = accountType;
    //     this.status = status;
    //                 }

    public Account(int accountNumber, 
                    String name, 
                    int age, 
                    double balance,
                    String accountType
                    ){


        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
        this.status = "Active";
                    }
    
    // mthd - 1 
    public boolean deposit(double amount){
        // you can only deposit to an active account 
        if("Active".equals(this.status) && amount >= 0){
            this.balance += amount;
            return true;
        }
        else{
            return false;
        }
    }
    // mthd - 2 
    public boolean withdraw(double amount){
        // first check balance, only if its greater
        // than or equal then allow withdrawl
        if("Active".equals(this.status) && amount >= 0){
            if(this.balance >= amount){
                this.balance -= amount;
                return true;
            }
            else{
                //System.out.println("Insufficient Balance :( ");
                return false;
            }
        }
        else{
            return false;
        }
    }
    //GETTER METHODS 
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountType() {
        return accountType;
    }
    public String getStatus() {
        return status;
    }
    // SETTER METHODS 
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    



}

