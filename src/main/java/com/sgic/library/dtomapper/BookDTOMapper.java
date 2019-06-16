package com.sgic.library.dtomapper;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.library.dto.BookDTO;
import com.sgic.library.entity.Book;
import com.sgic.library.service.BookServiceImplement;

@Service
public class BookDTOMapper {
	
	@Autowired
	private BookServiceImplement bookServiceImpl;
	
	ModelMapper modelMapper = new ModelMapper();

	private BookDTO EntityToDTO(Book book) {
		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
		return bookDTO;
	}
	
	PropertyMap <BookDTO, Book> BookMap = new PropertyMap <BookDTO, Book>() {
		  protected void configure() {
			  map().getSubClassification().setSubClassId(source.getSubClassId());
		  }
		};
		

//	public void saveBook(BookDTO bookDTO) {
//		
//		// --- Explicit Mapping Entity to DTO
//		modelMapper.addMappings(new PropertyMap<Book, BookDTO>() {
//			protected void configure() {
//				map().setMainClassId(source.getMainClassification().getMainClassId());
//				map().setSubClassId(source.getSubClassification().getSubClassId());
//			}
//		});
	
//		// --- Explicit Mapping DTO to Entity	
//	PropertyMap <BookDTO, Book> orderMap = new PropertyMap <BookDTO, Book>() {
//		  protected void configure() {
//		    map().getMainClassification().setMainClassId(source.getMainClassId());
//		  }
//		};
//		
//		Book book = modelMapper.map(bookDTO, Book.class);
//		bookServiceImpl.save(book);
//	}

	public BookDTO getBook(String bookId) {
		return EntityToDTO(bookServiceImpl.getBookById(bookId));
	}
	
	public Book saveBook(BookDTO bookDTO) {
		TypeMap<BookDTO, Book> typeMap = modelMapper.getTypeMap(BookDTO.class, Book.class);
		if (typeMap == null) {
			modelMapper.addMappings(BookMap);
		}
		Book book= modelMapper.map(bookDTO, Book.class);
		return bookServiceImpl.save(book);
	}

	public List<BookDTO> getAllBook(){
		List<Book> book = bookServiceImpl.getAllBooks();
		Type listType = new TypeToken<List<BookDTO>>() {}.getType();
		List<BookDTO> returnValue = new ModelMapper().map(book, listType);
		
// --------------
//		List<BookDTO> models = new ModelMapper().map(book, listType);
//
//        for(int i = 0; i < models.size(); i++) {
//            System.out.println(models.get(i).getBookId());
//        }
// --------------
	
		return returnValue;
	}
	
	public BookDTO deleteBook(String bookId) {
		bookServiceImpl.deleteBookById(bookId);
		return null;
	}
	
	public Book updateBook(BookDTO bookDTO) {
		TypeMap<BookDTO, Book> typeMap = modelMapper.getTypeMap(BookDTO.class, Book.class);
		if (typeMap == null) {
			modelMapper.addMappings(BookMap);
		}
		Book book = modelMapper.map(bookDTO, Book.class);
		return bookServiceImpl.save(book);
		
	}


}
