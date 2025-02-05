package com.twopiradrian.auth_server.domain.dto.user.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.auth_server.domain.validator.RegexValidators;
import lombok.Getter;

@Getter
public class RegisterUserReq {

        private final String username;

        private final String password;

        private final String email;

        private RegisterUserReq(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public static RegisterUserReq create(String username, String password, String email) {

            if (username == null || password == null || email == null) {
                throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
            }

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
            }

            RegexValidators usernameValidator = RegexValidators.USERNAME;
            if (!username.matches(usernameValidator.getRegex())) {
                throw new ErrorHandler(ErrorType.INVALID_FIELDS);
            }

            RegexValidators passwordValidator = RegexValidators.PASSWORD;
            if (!password.matches(passwordValidator.getRegex())) {
                throw new ErrorHandler(ErrorType.INVALID_FIELDS);
            }

            RegexValidators emailValidator = RegexValidators.EMAIL;
            if (!email.matches(emailValidator.getRegex())) {
                throw new ErrorHandler(ErrorType.INVALID_FIELDS);
            }

            return new RegisterUserReq(username, password, email);
        }

}
