package inc.codeman.springboot.bookcatalogue.service.impl;

import inc.codeman.springboot.bookcatalogue.entity.BookInfo;
import inc.codeman.springboot.bookcatalogue.exception.BookNameAlreadyExistsException;
import inc.codeman.springboot.bookcatalogue.exception.ResourceNotFoundException;
import inc.codeman.springboot.bookcatalogue.mapper.AutoBookInfoMapper;
import inc.codeman.springboot.bookcatalogue.mapper.BookInfoMapper;
import inc.codeman.springboot.bookcatalogue.repository.BookInfoRepository;
import inc.codeman.springboot.bookcatalogue.service.BookInfoService;
import inc.codeman.springboot.bookcatalogue.dto.BookInfoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
@Primary
public class BookInfoServiceImpl implements BookInfoService {
    private BookInfoRepository repository;
    private BookInfoMapper bookInfoMapper;

    private ModelMapper modelMapper;


    @Autowired
    public BookInfoServiceImpl(BookInfoRepository repository,BookInfoMapper bookInfoMapper,ModelMapper modelMapper){
        this.repository = repository;
        this.bookInfoMapper=bookInfoMapper;
        this.modelMapper=modelMapper;
    }
    public BookInfoDTO createBook(BookInfoDTO bookInfoDTO){
        //BookInfo bookInfo = modelMapper.map(bookInfoDTO,BookInfo.class);
        //bookInfoMapper.mapDTOToEntity(bookInfoDTO);
        BookInfo bookInfo = AutoBookInfoMapper.MAPPER.mapToEntity(bookInfoDTO);
        if(repository.findByName(bookInfo.getName()).isPresent()){
            throw  new BookNameAlreadyExistsException(String.format("Book with name %s already exist",bookInfo.getName()));
        }
        BookInfo savedInfo = repository.save(bookInfo);
        return AutoBookInfoMapper.MAPPER.mapToDTO(bookInfo);
        //modelMapper.map(savedInfo,BookInfoDTO.class);
        //bookInfoMapper.mapEntityToDTO(savedInfo);
    }

    public BookInfoDTO getBookById(int id){
        BookInfo result = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","Id",id));
        BookInfoDTO resultDTO = AutoBookInfoMapper.MAPPER.mapToDTO(result);
        //modelMapper.map(result,BookInfoDTO.class);
        //bookInfoMapper.mapEntityToDTO(result);
        return resultDTO;
    }

    public List<BookInfoDTO> getAllBooks(){
        List<BookInfo> results = repository.findAll();
        List<BookInfoDTO> resultsDTO = new ArrayList<>();
        //results.forEach((result)->resultsDTO.add(bookInfoMapper.mapEntityToDTO(result)));
        //results.forEach((result)->resultsDTO.add(modelMapper.map(result,BookInfoDTO.class)));
        results.forEach((result)->resultsDTO.add(AutoBookInfoMapper.MAPPER.mapToDTO(result)));
        return resultsDTO;
    }

    @Override
    public BookInfoDTO updateBookInfo(int id, BookInfoDTO bookInfo) {
        BookInfoDTO updatedBookInfo = getBookById(id);
        updatedBookInfo.setName(bookInfo.getName());
        updatedBookInfo.setAuthors(bookInfo.getAuthors());
        updatedBookInfo.setPageCount(bookInfo.getPageCount());
        updatedBookInfo.setPublisher(bookInfo.getPublisher());
        updatedBookInfo.setRating(bookInfo.getRating());
        updatedBookInfo.setYear(bookInfo.getYear());
        if(repository.findByName(updatedBookInfo.getName()).isPresent() && repository.findByName(updatedBookInfo.getName()).get().getId()!=(updatedBookInfo.getId())){
            throw  new BookNameAlreadyExistsException(String.format("Book with name %s already exist",updatedBookInfo.getName()));
        }
        BookInfo result =repository.save(AutoBookInfoMapper.MAPPER.mapToEntity(updatedBookInfo));
        //repository.save(modelMapper.map(updatedBookInfo,BookInfo.class));
        //repository.save(bookInfoMapper.mapDTOToEntity(updatedBookInfo));
        return AutoBookInfoMapper.MAPPER.mapToDTO(result);
        //modelMapper.map(result,BookInfoDTO.class);
        //bookInfoMapper.mapEntityToDTO(result);
    }

    @Override
    public void deleteBookInfo(int id) {


        BookInfo existingBookInfo = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book","Id", id));
        repository.deleteById(id);
    }




}
