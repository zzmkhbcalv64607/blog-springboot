package com.liella.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liella.entity.Menu;
import com.liella.model.dto.ConditionDTO;
import com.liella.model.dto.MenuDTO;
import com.liella.model.vo.MenuOption;
import com.liella.model.vo.MenuTree;
import com.liella.model.vo.MenuVO;

import java.util.List;

/**
 * 菜单业务接口
 *
 * @author  liyuu
 * @date 2022/12/05 22:13
 **/
public interface MenuService extends IService<Menu> {

    /**
     * 查看菜单列表
     *
     * @param condition 查询条件
     * @return 菜单列表
     */
    List<MenuVO> listMenuVO(ConditionDTO condition);

    /**
     * 添加菜单
     *
     * @param menu 菜单
     */
    void addMenu(MenuDTO menu);

    /**
     * 删除菜单
     *
     * @param menuId 菜单id
     */
    void deleteMenu(Integer menuId);

    /**
     * 修改菜单
     *
     * @param menu 菜单
     */
    void updateMenu(MenuDTO menu);

    /**
     * 获取菜单下拉树
     *
     * @return 菜单下拉树
     */
    List<MenuTree> listMenuTree();

    /**
     * 获取菜单选项树
     *
     * @return 菜单选项树
     */
    List<MenuOption> listMenuOption();

    /**
     * 编辑菜单
     *
     * @param menuId 菜单id
     * @return 菜单
     */
    MenuDTO editMenu(Integer menuId);
}
