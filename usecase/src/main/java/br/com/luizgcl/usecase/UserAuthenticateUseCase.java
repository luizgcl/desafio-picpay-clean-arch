package br.com.luizgcl.usecase;

public interface UserAuthenticateUseCase {

    Boolean execute(String email, String password);

}
