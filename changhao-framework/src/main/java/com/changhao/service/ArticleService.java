package com.changhao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changhao.domain.ResponseResult;
import com.changhao.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();
}
