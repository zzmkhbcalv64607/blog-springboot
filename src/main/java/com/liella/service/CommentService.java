package com.liella.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liella.entity.Comment;
import com.liella.model.dto.CheckDTO;
import com.liella.model.dto.CommentDTO;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.vo.*;

import java.util.List;

/**
 * 评论业务接口
 *
 * @author  liyuu
 */
public interface CommentService extends IService<Comment> {

    /**
     * 查看后台评论列表
     *
     * @param condition 条件
     * @return 后台评论列表
     */
    PageResult<CommentBackVO> listCommentBackVO(ConditionDTO condition);

    /**
     * 添加评论
     *
     * @param comment 评论信息
     */
    void addComment(CommentDTO comment);

    /**
     * 审核评论
     *
     * @param check 审核信息
     */
    void updateCommentCheck(CheckDTO check);

    /**
     * 查看最新评论
     *
     * @return 最新评论
     */
    List<RecentCommentVO> listRecentCommentVO();

    /**
     * 查看评论
     *
     * @param condition 条件
     * @return 评论列表
     */
    PageResult<CommentVO> listCommentVO(ConditionDTO condition);

    /**
     * 查看回复评论
     *
     * @param commentId 评论id
     * @return 回复评论
     */
    List<ReplyVO> listReply(Integer commentId);
}
