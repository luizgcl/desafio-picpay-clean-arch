package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.Transaction;

public interface TransferUseCase {

    Boolean execute(Transaction transaction);

}
