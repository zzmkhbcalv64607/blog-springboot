package com.liella.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.liella.annotation.AccessLimit;
import com.liella.annotation.OptLogger;
import com.liella.annotation.VisitLogger;
import com.liella.enums.LikeTypeEnum;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.dto.TalkDTO;
import com.liella.model.vo.*;
import com.liella.service.TalkService;
import com.liella.strategy.context.LikeStrategyContext;
import com.liella.strategy.context.UploadStrategyContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.liella.constant.OptTypeConstant.*;
import static com.liella.enums.FilePathEnum.TALK;

/**
 * 说说控制器
 *
 * @author  liyuu
 **/
@Api(tags = "说说模块")
@RestController
public class TalkController {

    @Autowired
    private TalkService talkService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @Autowired
    private LikeStrategyContext likeStrategyContext;

    /**
     * 查看后台说说列表
     *
     * @param condition 条件
     * @return {@link TalkBackVO} 后台说说
     */
    @ApiOperation(value = "查看后台说说列表")
    @SaCheckPermission("web:talk:list")
    @GetMapping("/admin/talk/list")
    public Result<PageResult<TalkBackVO>> listTalkBackVO(ConditionDTO condition) {
        return Result.success(talkService.listTalkBackVO(condition));
    }

    /**
     * 上传说说图片
     *
     * @param file 文件
     * @return {@link Result<String>}
     */
    @OptLogger(value = UPLOAD)
    @ApiOperation(value = "上传说说图片")
    @ApiImplicitParam(name = "file", value = "相册封面", required = true, dataType = "MultipartFile")
    @SaCheckPermission("web:talk:upload")
    @PostMapping("/admin/talk/upload")
    public Result<String> uploadTalkCover(@RequestParam("file") MultipartFile file) {
        return Result.success(uploadStrategyContext.executeUploadStrategy(file, TALK.getPath()));
    }

    /**
     * 添加说说
     *
     * @param talk 说说信息
     * @return {@link Result<>}
     */
    @OptLogger(value = ADD)
    @ApiOperation(value = "添加说说")
    @SaCheckPermission("web:talk:add")
    @PostMapping("/admin/talk/add")
    public Result<?> addTalk(@Validated @RequestBody TalkDTO talk) {
        talkService.addTalk(talk);
        return Result.success();
    }

    /**
     * 删除说说
     *
     * @param talkId 说说id
     * @return {@link Result<>}
     */
    @OptLogger(value = DELETE)
    @ApiOperation(value = "删除说说")
    @SaCheckPermission("web:talk:delete")
    @DeleteMapping("/admin/talk/delete/{talkId}")
    public Result<?> deleteTalk(@PathVariable("talkId") Integer talkId) {
        talkService.deleteTalk(talkId);
        return Result.success();
    }

    /**
     * 修改说说
     *
     * @param talk 说说信息
     * @return {@link Result<>}
     */
    @OptLogger(value = UPDATE)
    @ApiOperation(value = "修改说说")
    @SaCheckPermission("web:talk:update")
    @PutMapping("/admin/talk/update")
    public Result<?> updateTalk(@Validated @RequestBody TalkDTO talk) {
        talkService.updateTalk(talk);
        return Result.success();
    }

    /**
     * 编辑说说
     *
     * @param talkId 说说id
     * @return {@link TalkBackVO} 后台说说
     */
    @ApiOperation(value = "编辑说说")
    @SaCheckPermission("web:talk:edit")
    @GetMapping("/admin/talk/edit/{talkId}")
    public Result<TalkBackInfoVO> editTalk(@PathVariable("talkId") Integer talkId) {
        return Result.success(talkService.editTalk(talkId));
    }

    /**
     * 点赞说说
     *
     * @param talkId 说说id
     * @return {@link Result<>}
     */
    @SaCheckLogin
    @ApiOperation(value = "点赞说说")
    @AccessLimit(seconds = 60, maxCount = 3)
    @SaCheckPermission("web:talk:like")
    @PostMapping("/talk/{talkId}/like")
    public Result<?> saveTalkLike(@PathVariable("talkId") Integer talkId) {
        likeStrategyContext.executeLikeStrategy(LikeTypeEnum.TALK, talkId);
        return Result.success();
    }

    /**
     * 查看首页说说
     *
     * @return {@link Result<String>}
     */
    @ApiOperation(value = "查看首页说说")
    @GetMapping("/home/talk")
    public Result<List<String>> listTalkHome() {
        return Result.success(talkService.listTalkHome());
    }

    /**
     * 查看说说列表
     *
     * @return {@link Result<TalkVO>}
     */
    @VisitLogger(value = "说说列表")
    @ApiOperation(value = "查看说说列表")
    @GetMapping("/talk/list")
    public Result<PageResult<TalkVO>> listTalkVO() {
        return Result.success(talkService.listTalkVO());
    }

    /**
     * 查看说说
     *
     * @param talkId 说说id
     * @return {@link Result<TalkVO>}
     */
    @VisitLogger(value = "说说")
    @ApiOperation(value = "查看说说")
    @GetMapping("/talk/{talkId}")
    public Result<TalkVO> getTalkById(@PathVariable("talkId") Integer talkId) {
        return Result.success(talkService.getTalkById(talkId));
    }
}