package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {


    public void createKeyword(@Param("id") int id,@Param("keyword") String keyword);
    
}
