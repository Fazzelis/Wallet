package backend.wallet.api.dto.user;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserPatchDto(
        String lastName,
        String firstName,
        String middleName,
        LocalDate birthday
) {
}
