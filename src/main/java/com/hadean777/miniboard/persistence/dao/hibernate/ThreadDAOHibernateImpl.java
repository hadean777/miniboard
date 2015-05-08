package com.hadean777.miniboard.persistence.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.persistence.dao.ThreadDAO;
import com.hadean777.miniboard.persistence.pojo.Thread;

@Repository("threadDao")
@Transactional
public class ThreadDAOHibernateImpl extends GenericDAOHibernateImpl<Thread, Long> 
implements ThreadDAO {

	public List<Thread> getAllThreads() throws DAOException{
		
        List<Thread> threadList = null;
        try {
            Query query = getSession().createQuery("from Thread");
            threadList = (List<Thread>) query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return threadList;
	}

}
