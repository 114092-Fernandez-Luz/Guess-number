package ar.edu.utn.frc.tup.lciii.helpers;

import ar.edu.utn.frc.tup.lciii.dtos.UserDto;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.User;
import org.modelmapper.ModelMapper;

public class UserHelper {

    public static final String EMAIL_OK = "email@email.com";
    public static final String EMAIL_NOT_OK = "email_email.com";
    public static final String USERNAME = "tuplciii";

    private  static  final ModelMapper modelMapper = new ModelMapper();

    public static User getUser(String userName, String email){
        User user = new User();
        user.setId(1l);
        user.setUserName(userName);
        user.setEmail(email);
        return user;
    }

    public static UserEntity getUserEntity(String userName, String email){
        UserEntity userEntity = modelMapper.map(getUser(userName, email), UserEntity.class);
        userEntity.setId(null);
        return  userEntity;

    }


}
