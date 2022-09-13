package uz.pdp.libraryapp2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewResponse {
    private String message;
    private boolean success;
}
