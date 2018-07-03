package com.example.greendaodemo.sql.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.greendaodemo.sql.bean.Book;
import com.example.greendaodemo.sql.bean.Shop;

import com.example.greendaodemo.sql.dao.BookDao;
import com.example.greendaodemo.sql.dao.ShopDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookDaoConfig;
    private final DaoConfig shopDaoConfig;

    private final BookDao bookDao;
    private final ShopDao shopDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        shopDaoConfig = daoConfigMap.get(ShopDao.class).clone();
        shopDaoConfig.initIdentityScope(type);

        bookDao = new BookDao(bookDaoConfig, this);
        shopDao = new ShopDao(shopDaoConfig, this);

        registerDao(Book.class, bookDao);
        registerDao(Shop.class, shopDao);
    }
    
    public void clear() {
        bookDaoConfig.clearIdentityScope();
        shopDaoConfig.clearIdentityScope();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public ShopDao getShopDao() {
        return shopDao;
    }

}
