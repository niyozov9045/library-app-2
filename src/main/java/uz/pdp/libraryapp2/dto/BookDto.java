package uz.pdp.libraryapp2.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class BookDto {

    private Integer id;
    private String title;
    private String isbn;
    private Integer count;
    private String description;
    private List<AuthorDto> authorDtoList;
    private List<Integer> authorsIds;
    private List<CategoryDto> categoryDtoList;
    private List<Integer> categoriesIds;
    private Integer languageId;
    private String languageName;

    public Object getIsbn() {
        return null;
    }
}
