package com.wuyiwen.service;

import com.wuyiwen.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    // insert
    int addBook(Books books);

    // delete
    int deleteById(int id);

    // update
    int updateById(Books books);

    // select
    Books selectById(int id);

    // selectAll
    List<Books> selectAll();

    List<Books> queryBookByName(String bookName);
}
