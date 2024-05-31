package br.com.luizgcl.application.usecaseimpl;

import br.com.luizgcl.application.gateway.CreateUserGateway;
import br.com.luizgcl.core.domain.TransactionPin;
import br.com.luizgcl.core.domain.User;
import br.com.luizgcl.core.domain.Wallet;
import br.com.luizgcl.core.exception.EmailException;
import br.com.luizgcl.core.exception.TaxNumberException;
import br.com.luizgcl.core.exception.enums.ErrorCodeEnum;
import br.com.luizgcl.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;

    private final CreateUserGateway createUserGateway;

    private final CreateWalletUseCase createWalletUseCase;
    private final CreateTransactionPinUseCase createTransactionPinUseCase;

    public CreateUserUseCaseImpl(
            TaxNumberAvailableUseCase taxNumberAvailableUseCase,
            EmailAvailableUseCase emailAvailableUseCase,
            CreateUserGateway createUserGateway,
            CreateWalletUseCase createWalletUseCase,
            CreateTransactionPinUseCase createTransactionPinUseCase
    ) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
    }

    @Override
    public void execute(User user, String pin) {
        if (!taxNumberAvailableUseCase.execute(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.execute(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var userSaved = this.createUserGateway.execute(user);

        this.createWalletUseCase.execute(new Wallet(BigDecimal.ZERO, userSaved));
        this.createTransactionPinUseCase.execute(new TransactionPin(userSaved, pin));
    }

}
