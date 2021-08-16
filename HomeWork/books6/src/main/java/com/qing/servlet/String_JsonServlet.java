package com.qing.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qing.entity.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "String_JsonServlet", value = "/String_JsonServlet")
public class String_JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "tom");
        map.put("age", 18);
        map.put("gender", "男");
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(map);
        System.out.println(string);
        System.out.println("-------------------------------------");

        Person alice = new Person("alice", 18, false);
        String string1 = mapper.writeValueAsString(alice);
        System.out.println(string1);
        System.out.println("-------------------------------------");

        Person person1 = new Person("person1", 19, true);
        Person person2 = new Person("person2", 20, false);
        Person person3 = new Person("person3", 21, true);
        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        String string2 = mapper.writeValueAsString(list);
        System.out.println(string2);
        System.out.println("-------------------------------------");

        String json = "{\"gender\":true,\"name\":\"jacket\",\"age\":21}";
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
        System.out.println("-------------------------------------");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
