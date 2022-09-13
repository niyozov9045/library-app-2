package uz.pdp.libraryapp2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data@Builder
public class Book {

    private Integer id;
    private String title;
    private String description;
    private String total_count;
    private List<Author> authors;
    private String isbn;
    private List<Category> category;
    private Language language;
}
