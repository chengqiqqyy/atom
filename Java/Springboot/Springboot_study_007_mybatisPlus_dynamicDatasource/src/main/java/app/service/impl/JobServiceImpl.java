package app.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import app.entity.Job;
import app.mapper.JobMapper;
import app.service.JobService;

@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService{

}
