package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.Transaction;

public interface TransactionValidateUseCase {

    Boolean execute(Transaction transaction);

}
