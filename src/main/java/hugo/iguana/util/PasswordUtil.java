package hugo.iguana.util;

public class PasswordUtil {

    private static final String PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

/*
(?=.*[0-9]) a digit must occur at least once
(?=.*[a-z]) a lower case letter must occur at least once
(?=.*[A-Z]) an upper case letter must occur at least once
(?=.*[@#$%^&+=]) a special character must occur at least once
(?=\\S+$) no whitespace allowed in the entire string
.{8,} at least 8 characters
*/

    public static boolean isNotValid(String senha) {
        return !isValid(senha);
    }

    /**
     * Retorna true se a senha for válida de acordo com:
     * 1 - Ter ao menos um dígito númerico;
     * 2 - Uma letra minúscula;
     * 3 - Uma letra maiúscula;
     * 4 - Um caractere especial;
     * 5 - Ao menos 8 caracteres;
     *
     * @param senha
     * @return
     */
    public static boolean isValid(String senha) {
        return senha != null && senha.matches(PATTERN);
    }
}