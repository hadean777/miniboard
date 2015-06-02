package com.hadean777.miniboard.persistence.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.persistence.dao.PostDAO;
import com.hadean777.miniboard.persistence.pojo.Post;


@Repository("postDao")
@Transactional
public class PostDAOHibernateImpl extends GenericDAOHibernateImpl<Post, Long> 
implements PostDAO {
	
	@Autowired
	private MessageSource messageSource;
	
	public List<Post> getNewPosts(Long p_threadUid) throws DAOException{
		//TODO: return only new posts
		if (p_threadUid == null) {
            throw new IllegalArgumentException(messageSource.getMessage(AppConstants.MSG_KEY_ERROR_PARAMS_NULL, new Object[]{"p_threadUid"}, null));
        }
		
		List<Post> result = null;
		try {
			Query query = getSession().createSQLQuery("select * from posts where THREAD_UID = :p_threadUid order by POST_UID").addEntity(Post.class);
            query.setParameter("p_threadUid", p_threadUid);
            result = (List<Post>) query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
		
		return result;
	}

}
