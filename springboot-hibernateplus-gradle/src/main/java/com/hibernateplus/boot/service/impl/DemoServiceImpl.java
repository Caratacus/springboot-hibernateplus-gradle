package com.hibernateplus.boot.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.hibernateplus.service.impl.ServiceImpl;
import com.hibernateplus.boot.po.Demo;
import com.hibernateplus.boot.service.DemoService;
import com.hibernateplus.boot.vo.DemoVO;

@Service
public class DemoServiceImpl extends ServiceImpl<Demo, DemoVO> implements DemoService {

}
