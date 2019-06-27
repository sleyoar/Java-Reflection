package reflect20190627.work2.dao.impl;

import reflect20190627.work2.dao.IUser;
import reflect20190627.work2.dao.User;

public class UserReal implements IUser {
    @Override
    public void add(User user) {
        System.out.println(user+"添加完成！");
        //return 1;
    }

    @Override
    public void delete(int id) {
        System.out.println("id为"+id+"的用户删除完成！");
        //return id;
    }
}
