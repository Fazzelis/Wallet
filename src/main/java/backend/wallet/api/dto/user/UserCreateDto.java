package backend.wallet.api.dto.user;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserCreateDto(
        String lastName,
        String firstName,
        String middleName,
        String phone,
        String email,
        LocalDate birthday,
        String password
) {
}
