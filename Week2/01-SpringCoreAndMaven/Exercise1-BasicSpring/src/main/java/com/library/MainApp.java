package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;

public class MainApp{
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository repository = context.getBean("bookRepository", BookRepository.class);
        repository.displayBook();
    }
}