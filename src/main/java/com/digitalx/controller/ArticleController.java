package com.digitalx.controller;
import com.digitalx.domain.BaseResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengjunlee
 * @create 2019-09-03 10:47
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/delete")
    @RequiresRoles(value = { "admin" })
    public Object deleteArticle(ModelMap model) {
        BaseResponse<Object> ret = new BaseResponse<Object>();
        ret.setCode(0);
        ret.setMsg("文章删除成功！");
        return ret;
    }

    @GetMapping("/read")
    @RequiresPermissions(value = { "article:read" })
    public Object readArticle(ModelMap model) {
        BaseResponse<Object> ret = new BaseResponse<Object>();
        ret.setCode(0);
        ret.setMsg("请您鉴赏！");
        return ret;
    }

}