package com.example.comparateur.user.mapper;


import com.example.comparateur.user.entity.AppUser;
import com.example.comparateur.user.dto.UserDto;
import com.example.comparateur.user.repository.UserRepository;
import org.springframework.stereotype.Component;
@Component

public class UserMapper {

    public AppUser toEntity(UserDto userDTO) {


        if(userDTO == null) {
            return null;
        }
        AppUser user = new AppUser();
        user.setId(userDTO.getId());
        user.setFavori(userDTO.getFavori());
        user.setLieuHabitation(userDTO.getLieuHabitation());
        user.setConsommation(userDTO.getConsommation());

        return user;
    }
    public UserDto toDto(AppUser user) {
        if(user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFavori(user.getFavori());
        userDto.setLieuHabitation(user.getLieuHabitation());
        userDto.setConsommation(user.getConsommation());

        return userDto;
    }
}
