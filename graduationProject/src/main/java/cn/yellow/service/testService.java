package cn.yellow.service;

import cn.yellow.entity.huangShiZhe;
import cn.yellow.entity.huangShiZheExample;
import cn.yellow.mappers.huangShiZheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testService {
    @Autowired
    private huangShiZheMapper zheMapper;

    public List<huangShiZhe> getH(huangShiZheExample h){
        return zheMapper.selectByExample(h);
    }
}
