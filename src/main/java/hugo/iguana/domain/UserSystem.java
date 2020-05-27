package hugo.iguana.domain;

import hugo.iguana.domain.enums.UserSystemProfile;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usu_user_system")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "usu_id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "usu_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "usu_dt_modification"))
})
public class UserSystem extends AbstractPersistentEntity {

    @Column(name = "usu_name")
    private String name;

    @Column(name = "usu_email", unique = true)
    private String email;

    @Column(name = "usu_password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_profiles", joinColumns = @JoinColumn(name = "usu_id"))
    @Column(name = "per_name")
    private Set<Integer> profiles = new HashSet<>();

    @PrePersist
    public void prePersist() {
        super.prePersist();
        addProfile(UserSystemProfile.COMMON_USER);
    }

    public List<UserSystemProfile> getProfiles() {
        return profiles.stream().map(x -> UserSystemProfile.toEnum(x)).collect(Collectors.toList());
    }

    public void addProfile(UserSystemProfile userSystemProfile) {
        if (userSystemProfile != null) {
            if (profiles == null) {
                profiles = new HashSet<>();
            }
            profiles.add(userSystemProfile.getCode());
        }
    }
}