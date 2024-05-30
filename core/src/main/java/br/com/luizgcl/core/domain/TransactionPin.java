package br.com.luizgcl.core.domain;

import br.com.luizgcl.core.exception.TransactionPinException;
import br.com.luizgcl.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransactionPin {

    private Long id;

    private User user;
    private String pin;
    private Integer attempt;

    private Boolean blocked;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin() {}

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocked) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        this.isValid();
        this.pin = pin;
    }

    private void isValid() throws TransactionPinException {
        if (this.pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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
        if (!(o instanceof TransactionPin that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getPin().equals(that.getPin())) return false;
        if (!getAttempt().equals(that.getAttempt())) return false;
        if (!getBlocked().equals(that.getBlocked())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getPin().hashCode();
        result = 31 * result + getAttempt().hashCode();
        result = 31 * result + getBlocked().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }

}
