package uz.pdp.libraryapp2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private int id;
    private String full_name;
    private String phone_number;
    private boolean isAdmin;
    private String password;
}
