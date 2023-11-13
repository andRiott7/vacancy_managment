package com.andriott.vacancy_managment.exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("User already exists");
  }
}
