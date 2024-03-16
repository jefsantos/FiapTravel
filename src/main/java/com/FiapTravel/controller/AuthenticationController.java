//package com.FiapTravel.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.FiapTravel.model.User;
//import com.FiapTravel.repository.UserRepository;
//import com.FiapTravel.user.request.UserAuthRequest;
//import com.FiapTravel.user.request.UserRequest;
//import com.FiapTravel.user.response.UserResponse;
//import com.FiapTravel.user.security.TokenService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("auth")
//public class AuthenticationController {
//    
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserRepository repository;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid UserAuthRequest data){
//        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//
//        var token = tokenService.generateToken((User) auth.getPrincipal());
//
//        return ResponseEntity.ok(new UserResponse(token));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody @Valid UserRequest data){
//        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
//
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//        User newUser = new User(data.login(), encryptedPassword, data.role());
//
//        this.repository.save(newUser);
//
//        return ResponseEntity.ok().build();
//    }
//}
//
