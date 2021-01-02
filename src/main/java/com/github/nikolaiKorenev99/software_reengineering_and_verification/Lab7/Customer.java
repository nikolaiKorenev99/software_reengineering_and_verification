package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab7;

public class Customer extends AbstractCustomer {
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        super(name, surname, email);
        this.customerType = customerType;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email);
        this.customerType = CustomerType.COMPANY;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdrawCustomerTypeCheck(sum);
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public double getCompanyOverdraftDiscount() {
        return companyOverdraftDiscount;
    }

    public void setCompanyOverdraftDiscount(double companyOverdraftDiscount) {
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return getFullName() + accountDescription;
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return getFullName() + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.getType();
    }

    private void withdrawForPerson(double sum) {
        if (account.getMoney() < 0) {
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee());
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    private void withdrawForCompany(double sum, double companyOverdraftDiscount) {
        if (account.getMoney() < 0) {
            // no discount for overdraft for not premium account
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    private void withdrawCustomerTypeCheck(double sum) {
        switch (customerType) {
            case COMPANY:
                if (account.getType().isPremium()) {
                    withdrawForCompany(sum, companyOverdraftDiscount / 2);
                } else {
                    withdrawForCompany(sum, this.companyOverdraftDiscount);
                }
                break;
            case PERSON:
                withdrawForPerson(sum);
                break;
        }
    }
}

