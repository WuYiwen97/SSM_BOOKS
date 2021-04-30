package com.wuyiwen.service;

import com.wuyiwen.dao.BookMapper;
import com.wuyiwen.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    //service -》 dao

    public int addBook(Books books) {
        return  bookMapper.addBook(books);
    }

    public int deleteById(int id) {
        return  bookMapper.deleteById(id);
    }

    public int updateById(Books books) {
        return bookMapper.updateById(books);
    }

    public Books selectById(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Books> selectAll() {
        return  bookMapper.selectAll();
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        return  bookMapper.queryBookName(bookName);
    }


}
