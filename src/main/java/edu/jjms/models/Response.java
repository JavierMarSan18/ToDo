package edu.jjms.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private Boolean isSuccess;
    private Payload<T> payload;
}
