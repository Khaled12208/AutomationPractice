package ObjectRepository;

public class UserLoginData {

    /**** User Login Data ********/
    protected static String Email;
    protected static String Password;

    /**** Setter and getter Function ********/

    public static String getEmail() {
	return Email;
    }

    public static void setEmail(Object email) {
	Email = (String) email;
    }

    public static String getPassword() {
	return Password;
    }

    public static void setPassword(Object password) {
	Password = (String) password;
    }

}
