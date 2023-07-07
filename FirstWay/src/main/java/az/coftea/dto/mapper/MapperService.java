package az.coftea.dto.mapper;

import org.modelmapper.ModelMapper;

public interface MapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
