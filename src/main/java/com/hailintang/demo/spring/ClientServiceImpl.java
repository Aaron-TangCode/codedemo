package com.hailintang.demo.spring;

/**
 * @author hailin.tang
 * @date 2020/5/24 3:25 下午
 * @function
 */
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    @Override
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
