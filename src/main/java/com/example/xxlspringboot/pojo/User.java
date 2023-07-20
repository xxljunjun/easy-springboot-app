package com.example.xxlspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private String sex;
}
