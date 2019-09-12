package com.org.test.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AccountPk implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String accountNumber;
    private String stateCodeFormatted;
    private Date modifiedOn;
    
    public AccountPk() {
    
    }
    
    public AccountPk(String accountNumber, String stateCodeFormatted, Date modifiedOn) {
        this.accountNumber = accountNumber;
        this.stateCodeFormatted = stateCodeFormatted;
        this.modifiedOn = modifiedOn;
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStateCodeFormatted() {
        return stateCodeFormatted;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        
        final AccountPk other = (AccountPk) object;
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (!Objects.equals(this.stateCodeFormatted, other.stateCodeFormatted)) {
            return false;
        }
        if (!Objects.equals(this.modifiedOn, other.modifiedOn)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.accountNumber);
        hash = 19 * hash + Objects.hashCode(this.stateCodeFormatted);
        hash = 19 * hash + Objects.hashCode(this.modifiedOn);
        return hash;
    }

    @Override
    public String toString() {
        return "AccountPk [" +
                "accountNumber=" + accountNumber + 
                ", stateCodeFormatted=" + stateCodeFormatted +
                ", modifiedOn=" + modifiedOn + "]";
    }

}
