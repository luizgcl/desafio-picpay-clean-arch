package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean execute(Transaction transaction, String email);

}
