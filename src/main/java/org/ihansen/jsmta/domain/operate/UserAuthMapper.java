package org.ihansen.jsmta.domain.operate;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ihansen.jsmta.domain.UserAuth;
import org.ihansen.jsmta.domain.UserAuthEX;

public interface UserAuthMapper {
    public static final String DATA_SOURCE_NAME = "db1";

    int countByExample(UserAuthEX example);

    int deleteByExample(UserAuthEX example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    List<UserAuth> selectByExample(UserAuthEX example);

    UserAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAuth record, @Param("example") UserAuthEX example);

    int updateByExample(@Param("record") UserAuth record, @Param("example") UserAuthEX example);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);

    int insertBatch(List<UserAuth> records);
}