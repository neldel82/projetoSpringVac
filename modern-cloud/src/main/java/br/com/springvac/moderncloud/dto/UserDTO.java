package br.com.springvac.moderncloud.dto;

import br.com.springvac.moderncloud.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String email;

    public UserDTO(User user) {
        this.name = user.getNome();
        this.email = user.getEmail();
    }
}