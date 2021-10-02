package com.example.springrestnosqlcassandra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonPrimDto {
    private final UUID id = UUID.randomUUID();
    @NotNull(message = "{name.notnull}")
    @NotEmpty(message = "{name.empty}")
    @Size(min = 2, max = 10, message = "{name.size.invalid}")
    @Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.name}")
    private String firstName;
    @NotNull(message = "{lastname.notnull}")
    @NotEmpty(message = "{lastname.empty}")
    @Size(min = 2, max = 10, message = "{lastname.size.invalid}")
    @Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.lastname}")
    private String lastName;
}
