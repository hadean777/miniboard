package com.hadean777.miniboard.model;

public final class AjaxResult {
	
	private boolean m_success = true;
    private String  m_message;
    private Object  m_data = null;
  
    public AjaxResult()
    {
    }
    
    public AjaxResult( final Object p_data )
    {
        m_data = p_data;
    }

    public AjaxResult( final Object p_data, final String p_message )
    {
        m_data = p_data;
        m_message = p_message;
    }
    
    public AjaxResult(final boolean p_success, final String p_message)
    {
    	m_success = p_success;
    	m_message = p_message;
    }
    
    public AjaxResult(final boolean p_success, final Object p_data, final String p_message)
    {
    	m_success = p_success;
    	m_data = p_data;
    	m_message = p_message;
    }

    public final boolean isSuccess()
    {
        return m_success;
    }

    public final void setSuccess( final boolean p_success )
    {
        m_success = p_success;
    }

    public final String getMessage()
    {
        return m_message;
    }

    public final void setMessage( final String p_message )
    {
        m_message = p_message;
    }

    public final Object getData()
    {
        return m_data;
    }

    public final void setData( final Object p_data )
    {
        m_data = p_data;
    }

}
