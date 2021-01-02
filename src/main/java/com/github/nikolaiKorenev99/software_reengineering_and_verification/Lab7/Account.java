package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab7;

public class Account {

    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private Money money;
    private Customer customer;

    public Account(AccountType type, int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
        money = new Money();
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }


    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }


    public String printCustomerAccount(Customer customer) {
        return "Account: IBAN: " + getIban() + ", Money: "
                + money.getMoney() + ", Account type: " + getType();
    }

    public String printCustomerDaysOverdrawn(Customer customer) {
        String accountDescription = "Account: IBAN: " + getIban()
                + ", Days Overdrawn: " + getDaysOverdrawn();
        return customer.getFullName() + accountDescription;
    }

    public String printCustomerMoney(Customer customer) {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + getIban() + ", Money: " + money.getMoney();
        return customer.getFullName() + accountDescription;
    }

    void withdrawCustomerTypeCheck(double sum, Customer customer) {
        if (getType().isPremium() && customer.getDiscountForCustomer().isCompany()) {
            // 50 percent discount for with premium account
            withdrawOverDraft(sum, (customer.getDiscountForCustomer().getCompanyOverdraftDiscount()
                    / customer.getDiscountForCustomer().getPremiumDiscount()));
        } else {
            withdrawOverDraft(sum, customer.getDiscountForCustomer().getCompanyOverdraftDiscount());
        }
    }

    public void withdraw(double sum, String currency) {
        if (!money.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdrawCustomerTypeCheck(sum, customer);
    }

    public double getMoney() {
        return money.getMoney();
    }

    private void withdrawOverDraft(double sum, double companyOverdraftDiscount) {
        if (money.getMoney() < 0) {
            // no discount for overdraft for not premium account
            money.setMoney((money.getMoney() - sum) - sum * overdraftFee() * companyOverdraftDiscount);
        } else {
            money.setMoney(money.getMoney() - sum);
        }
    }

    public void setMoney(double moneyV) {
        money.setMoney(moneyV);
    }

    public void setCurrency(String currency) {
        money.setCurrency(currency);
    }
}
