package ar.edu.utn.frc.tup.lciii.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @JsonProperty("username")
    private  String userName;

    //verifica lo que nos envían tenga formato de email
    @Email
    private  String email;
}
