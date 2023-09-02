package com.liella.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liella.entity.Album;
import com.liella.model.dto.AlbumDTO;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.vo.AlbumBackVO;
import com.liella.model.vo.AlbumVO;
import com.liella.model.vo.PageResult;

import java.util.List;

/**
 * 相册业务接口
 *
 * @author  liyuu
 */
public interface AlbumService extends IService<Album> {

    /**
     * 查看后台相册列表
     *
     * @param condition 条件
     * @return 后台相册列表
     */
    PageResult<AlbumBackVO> listAlbumBackVO(ConditionDTO condition);

    /**
     * 添加相册
     *
     * @param album 相册
     */
    void addAlbum(AlbumDTO album);

    /**
     * 删除相册
     *
     * @param albumId 相册id
     */
    void deleteAlbum(Integer albumId);

    /**
     * 修改相册
     *
     * @param album 相册
     */
    void updateAlbum(AlbumDTO album);

    /**
     * 编辑相册
     *
     * @param albumId 相册id
     * @return 相册信息
     */
    AlbumDTO editAlbum(Integer albumId);

    /**
     * 查看相册列表
     *
     * @return 相册列表
     */
    List<AlbumVO> listAlbumVO();
}
