package com.jeancharlesexe.apirest.v1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número cartão não pode ser vazia.")
    @Pattern(regexp = "\\d+", message = "O número deve conter 16 dígitos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode ser vazia.")
    @Size(min = 3, max = 100, message = "O nome do titular deve conter entre 3-100 caracteres.")
    private String nomeTitular;

    @NotNull
    @DecimalMin(value = "10", message = "O valor deve ser no mínimo R$10,00")
    @DecimalMax(value = "5000", message = "O valor deve ser no máximo R$5000,00")
    private Double valor;

    @NotNull(message = "A data de pagamento não pode ser vazia.")
    @FutureOrPresent(message = "A data de pagamento deve ser do presente ou futuro")
    private LocalDate dataPagamento;

    @NotBlank(message = "O Email não pode ser vazio.")
    @Email(message = "Email deve ser válido.")
    private String emailContato;
}
