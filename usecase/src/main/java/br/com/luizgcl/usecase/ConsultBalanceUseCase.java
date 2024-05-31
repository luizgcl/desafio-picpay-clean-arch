package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal execute(Wallet wallet);

}
