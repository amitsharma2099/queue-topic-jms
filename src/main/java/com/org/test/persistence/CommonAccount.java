package com.org.test.persistence;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Account")
@Table(name = "AccountsView", schema = "dbo")
@IdClass(AccountPk.class)
@NamedQueries({
    @NamedQuery(name = "Account.findByStateCodeFormatted", query = "SELECT c FROM Account c WHERE c.stateCodeFormatted = :stateCodeFormatted"),
    @NamedQuery(name = "Account.findNewAndModifiedActiveStateAccounts", query = "SELECT c FROM Account c WHERE (c.createdOn > :lastFullExportDate OR c.modifiedOn > :lastFullExportDate) and c.stateCodeFormatted = :stateCodeFormatted")
}) 
public class CommonAccount {
    
    @Id
    @Column(name = "AccountNumber")
    private String accountNumber;

    @Id
    @Column(name = "StateCodeFormatted")
    private String stateCodeFormatted;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @Column(name = "OrganizationNumber")
    private String organizationNumber;

    @Column(name = "Country")
    private String country;

    @Column(name = "CreatedByFullName")
    private String createdByFullName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn")
    private Date createdOn;

    @Column(name = "Currency")
    private String currency;

    @Column(name = "CustomerStatusFormatted")
    private String customerStatusFormatted;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "ModifiedByFullName")
    private String modifiedByFullName;

    @Column(name = "NumberOfEmployees")
    private Integer numberOfEmployees;

    @Column(name = "Revenue")
    private BigDecimal revenue;

    @Column(name = "StateCode")
    private Integer stateCode;

    public CommonAccount() {
        
    }

    //Create Getters & Setters

    @Override
    public String toString() {
        return "CommonAccountsView [accountNumber=" + accountNumber + ", organizationNumber="
                + organizationNumber + "]";
    }

}
