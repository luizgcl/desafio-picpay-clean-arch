package br.com.luizgcl.core.domain;

import br.com.luizgcl.core.domain.enums.UserTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {

    private Long id;

    private TransactionPin transactionPin;

    private BigDecimal balance;

    private User user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet() {
    }

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
         this.balance.add(value);
    }

    public void transfer(BigDecimal value) {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER) {
            throw
        }

        if (this.balance.compareTo(value) < 0) {
            throw
        }

        this.balance.subtract(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet wallet)) return false;

        if (getId() != null ? !getId().equals(wallet.getId()) : wallet.getId() != null) return false;
        if (!getTransactionPin().equals(wallet.getTransactionPin())) return false;
        if (!getBalance().equals(wallet.getBalance())) return false;
        if (!getUser().equals(wallet.getUser())) return false;
        if (!getCreatedAt().equals(wallet.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(wallet.getUpdatedAt()) : wallet.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }
}
