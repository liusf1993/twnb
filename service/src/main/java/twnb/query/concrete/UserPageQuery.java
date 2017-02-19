package twnb.query.concrete;

import com.lsf.twnb.query.base.PageQuery;
import com.lsf.twnb.entity.User;

/**
 * Condition for UserPageQuery Query
 */
public class UserPageQuery extends PageQuery<User> {
    private String username;
    private String id;
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
