package com.crud.springbootcrudwithredis.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("User")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

    int id;
    String name;
    int age;

}
