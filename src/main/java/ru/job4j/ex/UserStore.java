package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rsl = -1;
        User log = null;
        for (User i : users) {
            if (login.equals(i.getUsername())) {
                log = i;
                rsl++;
                break;
            }
        }
        if (rsl < 0) {
            throw new UserNotFoundException("The user is not in the list");
        }
        return log;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("The user is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (UserNotFoundException ea) {
            ea.printStackTrace();
        }
    }
}