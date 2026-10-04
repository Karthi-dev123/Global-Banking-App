public class AccountEnhanced{
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin ;


    //constructor - version 1
    // public Account(int accountNumber, String name, int age, double balance, String accountType, String status) {
    //     this. accountNumber = accountNumber;
    //     this.name = name;
    //     this.age = age;
    //     this.balance = balance;
    //     this.accountType = accountType;
    //     this.status = status;

    // } 
    public AccountEnhanced(int accountNumber, String name, int age, double balance, String accountType) {
        this. accountNumber = accountNumber;
        this.name = name;
        //this.age = age;
        if(age >= 18) this.age = age;
        else this.age = 18;
        //this.balance = balance;
        //this.accountType = accountType;
        if("Savings".equals(accountType)) this.accountType = "Savings";
        else if("Current".equals(accountType)) this.accountType = "Current";
        else this.accountType = "Savings";
        double minbalance = 0.0;
        if(this.accountType.equals("Savings")){
            minbalance = 500.0;
        }
        else{
            minbalance = 1000.0;
        }
        if(balance < minbalance){
            this.balance = minbalance;
        }
        else{
            this.balance = balance;
        }
        // ============== BELOW CODE WAS A BAD DESIGN ==============================
        // if(accountType.equals("Savings") && balance >= 500.0) this.balance = balance;
        // else if(accountType.equals("Savings") && balance < 500.0) this.balance = 500.0;
        // else if(accountType.equals("Current") && balance >= 1000.0) this.balance = balance;
        // else if(accountType.equals("Current") && balance < 1000.0) this. balance = 1000.0;

        this.status = "Active";
        this.pin = null;

    } 
    public boolean deposit(double amount) {
        if(this.status.equals("Active") ){
            if( amount > 0) {
                balance += amount;
                return true;
            }
            else {
                return false;
            } 
        }
        else{
            return false;
        }

    }
    public boolean withdraw (double amount, int pin) {

        if(this.status.equals("Active")){
            if(verifyPin(pin)){
                double minbalance = 0.0;
                if(this.accountType.equals("Savings")) {
                    minbalance = 500.0;
                }
                else {
                    minbalance = 1000.0;
                }
                if(amount <=  0){
                    return false;
                }
                if(balance - amount >= minbalance) {
                    balance-= amount;
                    return true;
                }
                else return false;
                
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    // pin methods 
    // SET PIN
    public boolean setPin(int pin){
        if(pin >= 1000 && pin <= 9999){
            // pin is valid so set it 
            this.pin = pin;
            return true;
        }
        else{
            return false;
        }
    }
    // VERIFY PIN 
    public boolean verifyPin(int pin){
        if(this.pin == null){
            return false;
        }

        // if(this.pin == pin){
        //     // pin is valid so return true
        //     return true;
        // }
        // else{
        //     return false;
        // }
        // simply the above like so 
        return this.pin == pin;
    }
    //HAS PIN 
    public boolean hasPin(){
        if(this.pin != null){
            return true;
        }
        else{
            return false;
        }
    }
    //getter methods 
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
    //setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean closeAccount() {
        if(this.status.equals("Active")) {
            this.status = "Inactive";
            return true;
        }
        return false;
    }
    public boolean reopenAccount() {
        if(this.status.equals("Inactive")) {
            this.status = "Active";
            return true;
        }
        return false;
    }
}

