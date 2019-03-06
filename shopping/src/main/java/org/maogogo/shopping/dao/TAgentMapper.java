package org.maogogo.shopping.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.maogogo.shopping.domain.TAgent;

import java.util.List;

@Mapper
public interface TAgentMapper {

    @Select("select * from t_agent")
    public List<TAgent> getList();

}
