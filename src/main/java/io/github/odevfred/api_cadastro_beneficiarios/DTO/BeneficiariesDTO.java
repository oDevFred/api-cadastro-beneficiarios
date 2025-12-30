package io.github.odevfred.api_cadastro_beneficiarios.DTO;

import java.util.List;

import io.github.odevfred.api_cadastro_beneficiarios.model.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiariesDTO {

    @NotBlank(message = "O primeiro nome não pode estar vazio ou nulo")
    private String firstName;

    @NotBlank(message = "O sobrenome não pode estar vazio ou nulo")
    private String lastName;

    @NotBlank(message = "O email não pode estar vazio ou nulo")
    private String email;

    @NotBlank(message = "O telefone não pode estar vazio ou nulo")
    private String phone;

    @NotBlank(message = "O endereço não pode estar vazio ou nulo")
    private String street;

    @NotBlank(message = "O bairro não pode estar vazio ou nulo")
    private String district;

    @NotBlank(message = "A cidade não pode estar vazio ou nulo")
    private String city;

    @NotBlank(message = "O estado não pode estar vazio ou nulo")
    private String state;

    @NotBlank(message = "O país não pode estar vazio ou nulo")
    private String country;

    @NotBlank(message = "O código postal não pode estar vazio ou nulo")
    private String postalCode;

    @NotBlank(message = "O plano não pode estar vazio ou nulo")
    private String plan;

    private List<Document> documents;
}
