package org.maogogo.shopping.service.impl;

import org.maogogo.shopping.dao.TAgentMapper;
import org.maogogo.shopping.domain.TAgent;
import org.maogogo.shopping.service.TAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TAgentServiceImpl implements TAgentService {


    @Autowired
    private TAgentMapper tAgentMapper;

    @Override
    public List<TAgent> getList() {
        return tAgentMapper.getList();
    }
}
