package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.jtams.model.Initiative;

public interface KeywordMapper {


    public void createKeyword(@Param("id") int id,@Param("keyword") String keyword);

	
    
}
