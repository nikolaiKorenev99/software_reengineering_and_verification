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

    public DiscountForCustomer getDiscountForCustomer() {
        return discountForCustomer;
    }

    public class DiscountForCustomer {
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
        public double getCompanyOverdraftDiscount() {
            return companyOverdraftDiscount;
        }

        public double getPremiumDiscount() {
            return premiumDiscount;
        }
    }

    private DiscountForCustomer createDiscountCustomer(CustomerType customerType,
                                                       double companyOverdraftDiscount, double premiumDiscount) {
        return new DiscountForCustomer(customerType, companyOverdraftDiscount, premiumDiscount);
    }

}

