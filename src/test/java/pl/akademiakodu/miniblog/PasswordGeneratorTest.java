package pl.akademiakodu.miniblog;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorTest {

    @Test
    public void generateBcryptPassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("nimda"));
        System.out.println(bCryptPasswordEncoder.encode("test"));
        //$2a$10$iVi8pTAvjDlOW2lh7lVtueSocxQz5gHaMrigK/NaxkQW/Pa.nRfV2
    }
}
