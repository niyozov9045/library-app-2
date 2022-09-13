package uz.pdp.libraryapp2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Records {
    private int id;
    private boolean is_returned;
    private LocalDateTime dateTime;
    private int user_id;
}
