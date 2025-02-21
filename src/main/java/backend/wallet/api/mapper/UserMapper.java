package backend.wallet.api.mapper;

import org.springframework.stereotype.Component;
import backend.wallet.api.dto.user.UserCreateDto;
import backend.wallet.api.dto.user.UserGetDto;
import backend.wallet.api.dto.user.UserPatchDto;
import backend.wallet.core.model.User;

@Component
public class UserMapper {

    public User map(UserCreateDto userCreateDto) {
        return User.builder()
                .lastName(userCreateDto.lastName())
                .firstName(userCreateDto.firstName())
                .middleName(userCreateDto.middleName())
                .phone(userCreateDto.phone())
                .email(userCreateDto.email())
                .birthday(userCreateDto.birthday())
                .password(userCreateDto.password())
                .build();
    }

    public UserGetDto map(User user) {
        return UserGetDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .build();
    }

    public User map(UserPatchDto userPatchDto) {
        return User.builder()
                .lastName(userPatchDto.lastName())
                .firstName(userPatchDto.firstName())
                .middleName(userPatchDto.middleName())
                .birthday(userPatchDto.birthday())
                .build();
    }
}
