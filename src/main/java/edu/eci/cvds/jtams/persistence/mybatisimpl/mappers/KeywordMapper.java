package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {
	 /**
	  *Registra una palabra clave 
	  * 
	  * @Param id ID de la palabra clave
	  * @param keyword palabra clave 
	  * 
	*/

    public void createKeyword(@Param("id") int id,@Param("keyword") String keyword);
    
}
