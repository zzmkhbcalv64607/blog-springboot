package com.liella.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liella.entity.TaskLog;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.vo.PageResult;
import com.liella.model.vo.TaskLogVO;

/**
 * 定时任务日志业务接口
 *
 * @author  liyuu
 */
public interface TaskLogService extends IService<TaskLog> {

    /**
     * 查看后台定时任务日志
     *
     * @param condition 条件
     * @return 后台定时任务日志
     */
    PageResult<TaskLogVO> listTaskLog(ConditionDTO condition);

    /**
     * 清空定时任务日志
     */
    void clearTaskLog();
}
