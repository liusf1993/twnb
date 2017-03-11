package com.lsf.twnb.dao;

import com.lsf.twnb.entity.Article;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.query.concrete.BlogPageQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Delete({
            "delete from Article",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into Article (id, title, ",
            "author, publishDate, ",
            "content, comment)",
            "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=CHAR}, ",
            "#{author,jdbcType=VARCHAR},now(), ",
            "#{content,jdbcType=LONGVARBINARY}, #{comment,jdbcType=LONGVARBINARY})"
    })
    int insert(ArticleWithContent record);

    int insertSelective(ArticleWithContent record);

    @Select({
            "select",
            "id, title, author, publishDate, content, comment",
            "from Article",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    ArticleWithContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithContent record);

    @Update({
            "update Article",
            "set title = #{title,jdbcType=CHAR},",
            "author = #{author,jdbcType=VARCHAR},",
            "publishDate = #{publishdate,jdbcType=DATE},",
            "content = #{content,jdbcType=LONGVARBINARY},",
            "comment = #{comment,jdbcType=LONGVARBINARY}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ArticleWithContent record);

    @Update({
            "update Article",
            "set title = #{title,jdbcType=CHAR},",
            "author = #{author,jdbcType=VARCHAR},",
            "publishDate = #{publishdate,jdbcType=DATE}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Article record);

    @Select({
            "select",
            "id, title, author, publishDate, content, comment",
            "from Article",
            "where author = #{username,jdbcType=VARCHAR} order by publishDate desc  limit 0,1"
    })
    @ResultMap("ResultMapWithBLOBs")
    ArticleWithContent getLastArtile(@Param(value = "username") String username);


    @Select({
            "select",
            "id, title, author, publishDate, content, comment",
            "from Article",
            "where author = #{username,jdbcType=VARCHAR} order by publishDate desc  limit 0,2"
    })
    @ResultMap("ResultMapWithBLOBs")
    List<ArticleWithContent> getRecentTwoArticle(String username);

    ArticleWithContent getNextArticle(@Param("currentBlogId") String currentBlogId, @Param("type") String type);

    ArticleWithContent getRecentArticle();

    List<Article> queryArticleList(BlogPageQuery username);

    @Select({
            "select",
            "id, title, author, publishDate, content, comment",
            "from Article",
            "where id = #{blogId}"
    })
    @ResultMap("ResultMapWithBLOBs")
    ArticleWithContent getArticleById(@Param("blogId") int blogId);

    ArticleWithContent getArticle(@Param("id") Integer id,@Param("author")String username,
                                  @Param("type")String type);
}