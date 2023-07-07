package com.example.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
//You can also create your own mapper
@Service
@AllArgsConstructor
public class MapperManager implements MapperService{
    private ModelMapper mapper;
//This strategy is typically used when mapping from a request object (e.g., DTO) to an entity or domain model.
    @Override
    public ModelMapper forRequest() {
         this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
         return this.mapper;
    }
//This strategy is commonly used when mapping from an entity or domain model to a response object (e.g., DTO).
    @Override
    public ModelMapper forResponse() {
        this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.mapper;
    }
}
