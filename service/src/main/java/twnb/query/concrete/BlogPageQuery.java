package twnb.query.concrete;

import com.lsf.twnb.query.base.PageQuery;
import com.lsf.twnb.entity.Article;

/**
 * 博客查询条件
 */
public class BlogPageQuery extends PageQuery<Article> {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
