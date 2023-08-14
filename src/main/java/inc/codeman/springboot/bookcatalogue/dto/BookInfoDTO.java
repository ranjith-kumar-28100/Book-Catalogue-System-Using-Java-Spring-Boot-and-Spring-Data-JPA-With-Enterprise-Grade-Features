package inc.codeman.springboot.bookcatalogue.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "BookInfo DTO")
public class BookInfoDTO {
    private int id;
    @NotEmpty(message = "Name field should not be empty")
    @Schema(description = "BookInfo Name")
    private String name;
    @Schema(description = "BookInfo Page Count")
    @Min(value = 1, message = "Page count should not be less than 1")
    private int pageCount;
    @Schema(description = "BookInfo Publisher Details")
    @NotNull(message = "Publisher field should not be NULL")
    private String publisher;
    @Schema(description = "BookInfo Year of Publication")
    private int year;
    @Schema(description = "BookInfo Authors Details")
    @NotEmpty(message = "Authors field should not be empty")
    private String authors;
    @Schema(description = "BookInfo Ratings Recieved")
    @Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 5, message = "Rating should not be greater than 5")
    private double rating;

}
