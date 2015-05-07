package com.hadean777.miniboard.persistence.dao.hibernate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.persistence.dao.ThreadDAO;
import com.hadean777.miniboard.persistence.pojo.Thread;

@Repository("threadDao")
@Transactional
public class ThreadDAOHibernateImpl extends GenericDAOHibernateImpl<Thread, Long> 
implements ThreadDAO {


}
