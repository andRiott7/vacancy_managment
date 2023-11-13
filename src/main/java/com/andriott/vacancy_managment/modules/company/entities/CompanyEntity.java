package com.andriott.vacancy_managment.modules.company.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "company")
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  @NotBlank(message = "[username] field cannot be blank")
  @Pattern(regexp = "\\S+", message = "[username]  field cannot contain spaces")
  private String username;

  @Email(message = "Please enter a valid [email] address")
  private String email;

  @Length(min = 10, max = 100, message = "[password] must contain (10) to (100) characters")
  private String password;
  private String website;
  private String description;

}
