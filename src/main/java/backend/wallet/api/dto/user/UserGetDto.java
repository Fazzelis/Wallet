package backend.wallet.api.dto.user;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserGetDto(
        String lastName,
        String firstName,
        String middleName,
        String phone,
        String email,
        LocalDate birthday
) {
}
