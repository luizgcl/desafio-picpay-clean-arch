package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.User;

public interface FindUserByTaxNumberUseCase {

    User execute(String taxNumber);

}
