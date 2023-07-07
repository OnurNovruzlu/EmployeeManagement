package com.example.mapper;

import org.modelmapper.ModelMapper;

public interface MapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
