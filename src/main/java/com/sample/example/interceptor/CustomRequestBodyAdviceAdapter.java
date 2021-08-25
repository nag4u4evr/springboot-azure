package com.sample.example.interceptor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    @Autowired
    HttpServletRequest httpServletRequest;
	List<Object> list=new ArrayList<>();

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {

        // here you can full log httpServletRequest and body.
    
    	ObjectMapper a=new ObjectMapper();
    	try {
    		System.out.println("logging before save method==========================================>"); 
    		list.add(body);
			System.out.println(a.writeValueAsString(body));
			System.out.println("list size is=========================================================>"+list.size());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

	
}