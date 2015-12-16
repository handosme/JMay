package org.ihansen.jsmta.domain.operate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ihansen.jsmta.domain.BusLog;
import org.ihansen.jsmta.domain.BusLogEX;

public interface BusLogMapper {
    public static final String DATA_SOURCE_NAME = "db2";

    int countByExample(BusLogEX example);

    int deleteByExample(BusLogEX example);

    int deleteByPrimaryKey(Long id);

    int insert(BusLog record);

    int insertSelective(BusLog record);

    List<BusLog> selectByExample(BusLogEX example);

    BusLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BusLog record, @Param("example") BusLogEX example);

    int updateByExample(@Param("record") BusLog record, @Param("example") BusLogEX example);

    int updateByPrimaryKeySelective(BusLog record);

    int updateByPrimaryKey(BusLog record);

    int insertBatch(List<BusLog> records);
}