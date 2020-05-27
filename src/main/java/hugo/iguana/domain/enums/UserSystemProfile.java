package hugo.iguana.domain.enums;

import lombok.Getter;

@Getter
public enum UserSystemProfile {

    ADMIN(1, "ROLE_ADMIN"),
    COMMON_USER(2, "ROLE_COMMON_USER");

    private int code;
    private String role;

    private UserSystemProfile(Integer code, String role) {
        this.code = code;
        this.role = role;
    }

    public static UserSystemProfile toEnum(Integer cod) {
        for (UserSystemProfile p : UserSystemProfile.values()) {
            if (cod.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + cod);
    }
}
