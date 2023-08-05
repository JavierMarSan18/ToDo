package edu.jjms.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Payload<T> implements IPayload<T>{
    private T content;

    @Override
    public T extractContent() {
        return content;
    }
}
