package inc.codeman.springboot.bookcatalogue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookInfo {
@Id()
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false,unique = true)
private String name;
private int pageCount;
private String publisher;
@Column(nullable = false)
private int year;
private String authors;
private double rating;

}

