package io.avchain.rhymecard.dto.response;

// https://solbel.tistory.com/332

public class BankDto {
    int bankSeq;
    String bankCode;
    String display;

    public int getBankSeq() {
        return bankSeq;
    }

    public void setBankSeq(int bankSeq) {
        this.bankSeq = bankSeq;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
