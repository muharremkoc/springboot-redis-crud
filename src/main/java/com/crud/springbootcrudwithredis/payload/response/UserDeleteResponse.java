package com.crud.springbootcrudwithredis.payload.response;

import lombok.*;

@Data
@AllArgsConstructor
public class UserDeleteResponse {
    @NonNull
    private String message;
}