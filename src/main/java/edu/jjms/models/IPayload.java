package edu.jjms.models;

public interface IPayload<T> {
    T extractContent();
}
