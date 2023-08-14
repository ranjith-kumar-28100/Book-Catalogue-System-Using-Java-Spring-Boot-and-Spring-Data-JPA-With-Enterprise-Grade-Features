package inc.codeman.springboot.bookcatalogue.repository;

import inc.codeman.springboot.bookcatalogue.entity.BookInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface BookInfoRepository extends JpaRepository<BookInfo,Integer> {
    Optional<BookInfo> findByName(String name);
}
