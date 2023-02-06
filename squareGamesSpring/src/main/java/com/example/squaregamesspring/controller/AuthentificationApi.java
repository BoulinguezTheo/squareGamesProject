package com.example.squaregamesspring.controller;

import com.example.squaregamesspring.dao.repository.UserRepository;
import com.example.squaregamesspring.dto.UserDto;
import com.example.squaregamesspring.dto.UserEntity;
import com.example.squaregamesspring.security.MyUserDetailsService;
import com.example.squaregamesspring.security.MySecurityConfig;
import com.example.squaregamesspring.security.test.AuthenticationRequest;
import com.example.squaregamesspring.security.test.JwtTokenUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
//@RequestMapping(path="api/public")
public class AuthentificationApi {
    private final MySecurityConfig mySecurityConfig;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserRepository userRepo;
    private final long TOKEN_DURATION = 3600 * 1000L;
    private final String KEY = "e9sng4q";

    private final AuthenticationManager authenticationManager;

    public AuthentificationApi(AuthenticationManager authenticationManager, MySecurityConfig mySecurityConfig) {
        this.authenticationManager = authenticationManager;
        this.mySecurityConfig = mySecurityConfig;
    }


    @PostMapping("api/public/login")
    public ResponseEntity<?> login(@RequestBody /*@Valid*/ AuthenticationRequest request) throws Exception {

        try{
            UsernamePasswordAuthenticationToken tokenAuth =  new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            final Authentication authenticate;
            try{
                authenticate = authenticationManager.authenticate(tokenAuth);
            }catch(BadCredentialsException e){
                throw new Exception("Incorrect username or password", e);
            }

            //UserEntity = objet Entity qye vous avez crée et renvoyé par loadbyusername()
            final UserEntity user = (UserEntity) authenticate.getPrincipal();
            final String token = Jwts.builder()
                    .setSubject(authenticate.getName())
                    .claim("authorities", authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + TOKEN_DURATION))
                    .signWith(SignatureAlgorithm.HS512, KEY.getBytes())
                   .compact();

            //Conversion du user en UserDto
            UserDto userDto = new UserDto(user);


            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(userDto);
        }catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("api/public/new/user")
    public void newUser(@RequestBody @Valid UserDto userDto){
        String name = userDto.getUsername();
        String password = userDto.getPassword();
        String encryptedPassword = MySecurityConfig.passwordEncoder().encode(password);

        UserEntity userEntity = new UserEntity();
       userEntity.setUsername(name);
        userEntity.setPassword(encryptedPassword);
        userRepo.save(userEntity);
   }
}

//package com.example.squaregamesspring.controller;
//
//        import com.example.squaregamesspring.dto.UserDto;
//        import com.example.squaregamesspring.dto.UserEntity;
//        import com.example.squaregamesspring.security.*;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.security.authentication.AuthenticationManager;
//        import org.springframework.security.authentication.BadCredentialsException;
//        import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//        import org.springframework.security.core.userdetails.UserDetails;
//        import org.springframework.web.bind.annotation.PostMapping;
//        import org.springframework.web.bind.annotation.RequestBody;
//        import org.springframework.web.bind.annotation.RestController;
//        import javax.validation.Valid;
//
//@RestController
////@RequestMapping(path="api/public")
//public class AuthentificationApi {
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    private final long TOKEN_DURATION = 3600 * 1000L;
//    private final String KEY = "e9sng4q";
//
//
//    @PostMapping("api/public/login")
//    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest request) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//}
