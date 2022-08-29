package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    private String clientId;
    private String name;
    private String surname;
    private String phoneNumber;
}
