package com.example.demo.resources.exceptions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {

    private LocalDateTime timeStamp;

    private String error;

    private Integer status;

    private String path;
}
