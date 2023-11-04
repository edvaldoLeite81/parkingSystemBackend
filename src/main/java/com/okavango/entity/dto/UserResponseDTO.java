package com.okavango.entity.dto;

import com.okavango.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String userName;
    private String role;

    public UserResponseDTO(User user){
        String profile = String.valueOf(user.getRole());
        id = user.getId();
        userName = user.getUserName();
        role = profile.substring("ROLE_".length());
    }

}
