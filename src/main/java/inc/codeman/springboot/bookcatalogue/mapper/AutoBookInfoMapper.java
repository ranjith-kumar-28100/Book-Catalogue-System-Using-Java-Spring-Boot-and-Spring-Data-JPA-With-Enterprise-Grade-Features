package inc.codeman.springboot.bookcatalogue.mapper;

import inc.codeman.springboot.bookcatalogue.dto.BookInfoDTO;
import inc.codeman.springboot.bookcatalogue.entity.BookInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoBookInfoMapper {
    AutoBookInfoMapper MAPPER = Mappers.getMapper(AutoBookInfoMapper.class);
    BookInfoDTO mapToDTO(BookInfo bookInfo);
    BookInfo mapToEntity(BookInfoDTO bookInfoDTO);
}
