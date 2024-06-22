package com.spring_GestSchool.spring_flutter.mobile.dto.response;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponsDto {
    public static Map<Object,Object> response(Object results,
                                              Object TotalItems,Object TotalPages,
                                              Object size,Object pages,Object nbrPage,
                                              Object currentPage,HttpStatus status
    ){
        Map<Object, Object> model = new HashMap<>();
        model.put("status",status.value());
        model.put("results",results);
        model.put("TotalItems",TotalItems);
        model.put("TotalPages",TotalPages);
        model.put("size",size);
        model.put("pages",pages);
        model.put("nbrPage",nbrPage);
        model.put("currentPage",currentPage);
        return model;
    }
    public static Map<Object,Object> response(Object results, HttpStatus status
    ){
        Map<Object, Object> model = new HashMap<>();
        model.put("status",status.value());
        model.put("results",results);
        return model;
    }
}
