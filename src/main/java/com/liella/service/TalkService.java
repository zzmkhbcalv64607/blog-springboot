package com.liella.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liella.entity.Talk;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.dto.TalkDTO;
import com.liella.model.vo.PageResult;
import com.liella.model.vo.TalkBackInfoVO;
import com.liella.model.vo.TalkBackVO;
import com.liella.model.vo.TalkVO;

import java.util.List;

/**
 * 说说业务接口
 *
 * @author  liyuu
 */
public interface TalkService extends IService<Talk> {

    /**
     * 查看后台说说列表
     *
     * @param condition 条件
     * @return {@link PageResult<TalkBackVO>} 说说列表
     */
    PageResult<TalkBackVO> listTalkBackVO(ConditionDTO condition);

    /**
     * 添加说说
     *
     * @param talk 说说
     */
    void addTalk(TalkDTO talk);

    /**
     * 删除说说
     *
     * @param talkId 说说id
     */
    void deleteTalk(Integer talkId);

    /**
     * 修改说说
     *
     * @param talk 说说
     */
    void updateTalk(TalkDTO talk);

    /**
     * 编辑说说
     *
     * @param talkId 说说id
     * @return 说说
     */
    TalkBackInfoVO editTalk(Integer talkId);

    /**
     * 查看首页说说
     *
     * @return 首页说说
     */
    List<String> listTalkHome();

    /**
     * 查看说说列表
     *
     * @return 说说列表
     */
    PageResult<TalkVO> listTalkVO();

    /**
     * 查看说说
     *
     * @param talkId 说说id
     * @return 说说
     */
    TalkVO getTalkById(Integer talkId);
}
