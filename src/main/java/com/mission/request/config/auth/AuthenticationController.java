//package com.mission.request.config.auth;
//
//import com.mission.request.service.authentication.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthenticationController {
//    private final AuthenticationService authenticationService;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
//        return ResponseEntity.ok(authenticationService.register(request));
//    }
//
//    @PostMapping("/authentication")
//    public ResponseEntity<AuthenticationResponse> generateToken(@RequestBody AuthenticationRequest request){
//        return ResponseEntity.ok(authenticationService.authenticationrequest(request));
//    }
//
//}
