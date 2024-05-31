package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.Transaction;

public interface CreateTransactionUseCase {

    void execute(Transaction transaction);

}
