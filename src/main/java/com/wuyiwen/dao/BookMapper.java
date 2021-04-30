package com.wuyiwen.dao;

import com.wuyiwen.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    // insert
    int addBook(Books books);

    // delete
    int deleteById(@Param("bookId") int id);

    // update
    int updateById(Books books);

    // select
    Books selectById(@Param("bookId") int id);

    // selectAll
    List<Books> selectAll();


    List<Books> queryBookName(@Param("bookName") String bookName);

}
