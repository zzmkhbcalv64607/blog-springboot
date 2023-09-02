package com.liella.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liella.entity.ExceptionLog;
import com.liella.model.dto.ConditionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 异常日志Mapper
 *
 * @author  liyuu
 */
@Repository
public interface ExceptionLogMapper extends BaseMapper<ExceptionLog> {

    /**
     * 查询异常日志
     *
     * @param limit     页码
     * @param size      大小
     * @param condition 条件
     * @return 异常日志列表
     */
    List<ExceptionLog> selectExceptionLogList(@Param("limit") Long limit, @Param("size") Long size, @Param("condition") ConditionDTO condition);
}




