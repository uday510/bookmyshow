package com.lld.bookmyshow;
import com.lld.bookmyshow.controllers.UserController;
import com.lld.bookmyshow.dto.SignupRequestDTO;
import com.lld.bookmyshow.models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;
	@Override
	public void run(String... args) throws Exception {
		SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
		signupRequestDTO.setEmail("uday@email.com");
		signupRequestDTO.setPassword("password1234");
		userController.signUp(signupRequestDTO);
	}
	public static void main(String[] args) {
		BaseModel baseModel = new BaseModel();
		SpringApplication.run(BookMyShowApplication.class, args);
	}
}
