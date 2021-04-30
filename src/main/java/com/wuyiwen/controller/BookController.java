package com.wuyiwen.controller;

import com.wuyiwen.pojo.Books;
import com.wuyiwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    //查询全部书籍 返回到书籍展示界面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.selectAll();
        model.addAttribute("list",books);
        return "allBook";

    }

    //跳转 添加书籍
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }


    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //重定向到 /allBook
    }

    //跳转 修改书籍界面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.selectById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.printf("updateBooks=>"+books);
        bookService.updateById(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String  queryBook(String queryBookName,Model model){
        List<Books> books = new ArrayList<>();
        books = bookService.queryBookByName(queryBookName);
        if (books == null || books.size() ==0 ){
            books = bookService.selectAll();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",books);
        return "allBook";
    }



}
