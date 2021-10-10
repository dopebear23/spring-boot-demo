package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GToken.GenerateToken;
import Model.User;
import Service.TokenService;
import Service.User_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controller {
	
	
	@Autowired
	private TokenService tokenService;
	
	GenerateToken generateToken = new GenerateToken();
	
	@Autowired
	private User_Service userservice;
	
	@PostMapping("register")
	public boolean saveUser(@RequestBody User user) {
		 return userservice.saveUser(user);
		
	}
	
	@GetMapping("users-list")
	public List<User> allusers() {
		 return userservice.getUsers();
	}
	
	
	@DeleteMapping("delete-user/{user_id}")
	public boolean deleteUser(@PathVariable("user_id") int user_id,User user) {
		user.setUser_id(user_id);
		return userservice.deleteUser(user);
	}

	@GetMapping("user/{user_id}")
	public List<User> alluserByID(@PathVariable("user_id") int user_id,User user) {
		 user.setUser_id(user_id);
		 return userservice.getUserByID(user);
		
	}
	
	@PostMapping("update-user/{user_id}")
	public boolean updateUser(@RequestBody User user,@PathVariable("user_id") int user_id) {
		user.setUser_id(user_id);
		return userservice.updateUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> login(@RequestBody User user)
	{
		int status;
		HttpHeaders httpHeader = null;
	
		// Authenticate User.
		status = userservice.Login(user.getUser_email(), user.getUser_password());
		
		/*
		 * If User is authenticated then Do Authorization Task.
		 */
		if (status > 0) 
		{
			/*
			 * Generate token.
			 */
			String tokenData[] = generateToken.createJWT(user.getUser_email(), "SaurabhTripathi", "JWT Token", 4320000);
			
			// get Token.
			String token = tokenData[0];
			
			System.out.println("Authorization :: " + token);

			// Create the Header Object
			httpHeader = new HttpHeaders();

			// Add token to the Header.
			httpHeader.add("Authorization", token);

			// Check if token is already exist.
			long isUserEmailExists = tokenService.getTokenDetail(user.getUser_email());
			
			/*
			 * If token exist then update Token else create and insert the token.
			 */
			if (isUserEmailExists > 0) 
			{
				tokenService.updateToken(user.getUser_email(), token, tokenData[1]);
			} 
			else 
			{
				tokenService.saveUserEmail(user.getUser_email(), status);
				tokenService.updateToken(user.getUser_email(), token, tokenData[1]);
			}

			return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
		} 
		
		// if not authenticated return  status what we get.
		else 
		{
			return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
		}
		

	}
}
