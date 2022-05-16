package com.dmall.uat.mallfront.models.visitor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Visitor {

    private String username;
    private String password;
    private String email;
}
