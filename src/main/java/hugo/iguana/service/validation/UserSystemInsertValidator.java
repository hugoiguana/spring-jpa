package hugo.iguana.service.validation;

import hugo.iguana.domain.UserSystem;
import hugo.iguana.dto.UserSystemDTO;
import hugo.iguana.resource.exception.FieldMessage;
import hugo.iguana.service.UserSystemService;
import hugo.iguana.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserSystemInsertValidator implements ConstraintValidator<UserSystemInsert, UserSystemDTO> {

    @Autowired
    private UserSystemService userSystemService;

    @Override
    public void initialize(UserSystemInsert ann) {
    }

    @Override
    public boolean isValid(UserSystemDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        UserSystem u = userSystemService.getRepository().findByEmail(dto.getEmail());
        if (u != null) {
            list.add(new FieldMessage("email", "E-mail already exists."));
        }
        if (PasswordUtil.isNotValid(dto.getPassword())) {
            list.add(new FieldMessage("pasrrod", "Invalid password. " +
                    "A senha deve ter no mínimo 8 caracteres com um dígito numérico, uma letra minúscula, " +
                    "uma maiúscula e um caractere especial."));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }

}