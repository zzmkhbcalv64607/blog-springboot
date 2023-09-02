package com.liella.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liella.entity.Friend;
import com.liella.model.vo.FriendBackVO;
import com.liella.model.vo.FriendVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链 Mapper
 *
 * @author  liyuu
 */
@Repository
public interface FriendMapper extends BaseMapper<Friend> {

    /**
     * 查看友链列表
     *
     * @return 友链列表
     */
    List<FriendVO> selectFriendVOList();

    /**
     * 查看友链后台列表
     *
     * @param limit   页码
     * @param size    大小
     * @param keyword 条件
     * @return 友链后台列表
     */
    List<FriendBackVO> selectFriendBackVOList(@Param("limit") Long limit, @Param("size") Long size, @Param("keyword") String keyword);

}




