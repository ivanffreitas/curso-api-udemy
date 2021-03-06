package br.com.ivanilson.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    //@JsonIgnore //ignorar o campo
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Liberar para escrita, listagem não
    private String password;
}
