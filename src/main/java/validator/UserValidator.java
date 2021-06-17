package validator;

import domain.User;

public class UserValidator {
	private String firstNameError = null;
    private String lastNameError = null;
    private String ageError = null;
    private String emailError = null;

    private boolean errors;

    public boolean hasErrors() {
        return errors;
    }

    public UserValidator() {
    }

    public UserValidator(User user) {
        validate(user);
    }

    public void validate(User user) {
        if (checkFirstName(user.getFirstName())) {
            errors = true;
        }
        if (checkLastName(user.getLastName())) {
            errors = true;
        }
        if (checkAge(user.getAge())) {
            errors = true;
        }
        if (checkEmail(user.getEmail())) {
            errors = true;
        }
    }

    public boolean checkFirstName(String name) {
        boolean error = false;
        String reg = "^(([A-Za-z]{1}[0-9A-Za-z]{0,30})|([Р-пр-џ]{1}[0-9Р-пр-џ]{0,30}))";

        if (name.length() < 2) {
            firstNameError = "Your name is too short";
            error = true;
        } else if (!name.matches(reg)) {
        	firstNameError = "Bad name";
            error = true;
        }

        return error;
    }

    public boolean checkLastName(String lastName) {
        boolean error = false;
        String reg = "^(([A-Za-z]{1}[0-9A-Za-z]{0,30})|([Р-пр-џ]{1}[0-9Р-пр-џ]{0,30}))";

        if (lastName.length() < 2) {
        	lastNameError = "Your surname is too short";
            error = true;
        } else if (!lastName.matches(reg)) {
        	lastNameError = "Bad surname";
            error = true;
        }

        return error;
    }

    public boolean checkAge(int age) {
        boolean error = false;

        if (age < 1) {
            ageError = "Age should be higher then 0";
            error = true;
        } else if (age > 90) {
            ageError = "Your age is too high";
            error = true;
        }

        return error;
    }

    public boolean checkEmail(String email) {
        boolean error = false;
        String reg = "^(([0-9A-Za-z]{1}[-0-9A-z\\.]{0,30}[0-9A-Za-z]?)@([-A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$";

        if (!email.matches(reg)) {
            emailError = "Un correct email";
            error = true;
        }

        return error;
    }

    public String getNameError() {
        return firstNameError;
    }

    public String getSurnameError() {
        return lastNameError;
    }

    public String getAgeError() {
        return ageError;
    }

    public String getEmailError() {
        return emailError;
    }
}
