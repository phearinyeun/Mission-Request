package com.mission.request.config.auth;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
   private String username;
   private String password;
}
