package com.home;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainServer {

    public static void main(String[] args){

        new ClassPathXmlApplicationContext("serviceApplicationContext.xml");
    }
}
