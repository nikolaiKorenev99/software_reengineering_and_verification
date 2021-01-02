package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab7;

public class Customer extends AbstractCustomer {
    private DiscountForCustomer discountForCustomer;
    Account account;
    public static final double COMPANY_DISCOUNT = 1;
    public static final double PREMIUM_COMPANY_DISCOUNT = 2;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        super(name, surname, email);
        this.account = account;
        discountForCustomer = createDiscountCustomer(customerType, COMPANY_DISCOUNT, COMPANY_DISCOUNT);
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email);
        this.account = account;
        discountForCustomer = createDiscountCustomer(CustomerType.COMPANY, companyOverdraftDiscount,
                PREMIUM_COMPANY_DISCOUNT);
    }

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdrawCustomerTypeCheck(sum);
    }

    private void withdrawOverDraft(double sum, double companyOverdraftDiscount) {
        if (account.getMoney() < 0) {
            // no discount for overdraft for not premium account
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    private void withdrawCustomerTypeCheck(double sum) {
        if (account.getType().isPremium() && discountForCustomer.isCompany()) {
            // 50 percent discount for with premium account
            withdrawOverDraft(sum, (discountForCustomer.companyOverdraftDiscount
                    / discountForCustomer.premiumDiscount));
        } else {
            withdrawOverDraft(sum, discountForCustomer.companyOverdraftDiscount);
        }
    }

    private class DiscountForCustomer {
        private CustomerType customerType;
        private double companyOverdraftDiscount;
        private double premiumDiscount;

        public DiscountForCustomer(CustomerType customerType, double companyOverdraftDiscount,
                                   double premiumDiscount) {
            this.customerType = customerType;
            this.companyOverdraftDiscount = companyOverdraftDiscount;
            this.premiumDiscount = premiumDiscount;
        }

        public boolean isCompany() {
            return customerType == CustomerType.COMPANY;
        }
    }

    private DiscountForCustomer createDiscountCustomer(CustomerType customerType,
                                                       double companyOverdraftDiscount, double premiumDiscount) {
        return new DiscountForCustomer(customerType, companyOverdraftDiscount, premiumDiscount);
    }

}

