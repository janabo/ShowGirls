package com.janabo.showgirls.dao;

import android.util.Log;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table RECOMMEND.
 */
public class Recommend implements java.io.Serializable {

    private Long id;
    private String type;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RecommendDao myDao;

    private List<RecommendContent> recommendContents;

    public Recommend() {
    }

    public Recommend(Long id) {
        this.id = id;
    }

    public Recommend(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendContents=" + recommendContents +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRecommendDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<RecommendContent> getRecommendContents() {
        if (recommendContents == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RecommendContentDao targetDao = daoSession.getRecommendContentDao();
            List<RecommendContent> recommendContentsNew = targetDao._queryRecommend_RecommendContents(id);
            Log.e("RecommendContent","recommendContentsNew"+recommendContentsNew);
            synchronized (this) {
                if(recommendContents == null) {
                    recommendContents = recommendContentsNew;
                }
            }
        }
        return recommendContents;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetRecommendContents() {
        recommendContents = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
