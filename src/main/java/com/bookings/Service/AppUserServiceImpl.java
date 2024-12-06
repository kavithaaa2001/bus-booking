package com.bookings.Service;

import com.bookings.entity.AppUser;
import com.bookings.payload.AppUserDto;
import com.bookings.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService{
    private AppUserRepository appUserRepository;


    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUserDto addUser(AppUserDto dto) {
        AppUser appUser = mapToEntity(dto);
        AppUser user = appUserRepository.save(appUser);
        AppUserDto userDto = maptoDto(user);
        return userDto;
    }

    private AppUserDto maptoDto(AppUser user) {
        AppUserDto dto = new AppUserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    private AppUser mapToEntity(AppUserDto dto) {
        AppUser user = new AppUser();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
}
