package com.changhao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changhao.domain.ResponseResult;
import com.changhao.domain.entity.Article;
import com.changhao.mapper.ArticleMapper;
import com.changhao.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {


    @Override
    public ResponseResult hotArticleList() {
        // Query hot article, and wrap query results into ResponseResult class
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        // the article must be the formal article, the draft is not allowed
        queryWrapper.eq(Article::getStatus, 0);
        // the result must sort by view count decreasing
        queryWrapper.orderByDesc(Article::getViewCount);

        // we only display 10 results
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();

        return ResponseResult.okResult(articles);
    }
}
