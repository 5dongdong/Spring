package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        //as-is
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        //to-be
        String Password = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(Password.length() >= 8 && Password.length() <= 12){
            this.password = Password;
        }
    }

    public String getPassword() {
        return password;
    }
}
