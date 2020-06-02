package hugo.iguana.domain.onetoone;

import org.springframework.beans.factory.annotation.Value;

public interface IOneToOneOneDirectional1NameOnly {

    String getName();

    @Value("#{target.id + ' ' + target.name}")
    String getFullName();

    default String getFullName2() {
        return getName().concat(" ").concat(getFullName());
    }

}
