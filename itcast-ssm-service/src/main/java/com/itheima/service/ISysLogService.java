package com.itheima.service;

import com.itheima.domian.SysLog;

import java.util.List;

public interface ISysLogService {
    void  save(SysLog sysLog)throws Exception;

    public List<SysLog> findAll() throws Exception;
}
