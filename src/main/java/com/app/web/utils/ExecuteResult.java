package com.app.web.utils;

import java.io.Serializable;

public class ExecuteResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private String            code;		//操作代码

    private String            errorMessage;	//自定义错误信息
    
    private T                 data;		//执行成功返回的数据
    
    private String 			  params;
    
    
    public boolean isOk()
    {
    	if(code.equals(GlobalVariable.DATALAYER_CODE_SUCCESS))
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public void SuccessResult(T data)
    {
    	this.code = GlobalVariable.DATALAYER_CODE_SUCCESS;
    	
    	this.data = data;
    }
    
    public void ErrorResult(String errorMessage)
    {
    	this.code = GlobalVariable.DATALAYER_CODE_ERROR;
    	
    	this.errorMessage = errorMessage;
    }
    
    public void ErrorResult(String errorMessage,String params)
    {
    	this.code = GlobalVariable.DATALAYER_FARMAT_ERROR;
    	
    	this.errorMessage = errorMessage;
    	
    	this.params = params;
    }
    
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}
