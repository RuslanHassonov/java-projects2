package be.mobyus.ie5.entities;

import javax.persistence.Embeddable;

@Embeddable
public class EshopInfo {
    private String vatNumber;
    private String bankAccountNumber;

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
