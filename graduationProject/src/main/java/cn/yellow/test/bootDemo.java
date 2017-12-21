package cn.yellow.test;

import cn.yellow.entity.huangShiZhe;
import cn.yellow.entity.huangShiZheExample;
import cn.yellow.mappers.huangShiZheMapper;
import cn.yellow.service.testService;
import com.dianping.zebra.dao.AsyncDaoCallback;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class bootDemo {

    @Autowired
    private huangShiZheMapper hsz;

    @RequestMapping("/")
    @ResponseBody
    public String testdeom() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping("/mybatis")
    public String testMybatis() {
        huangShiZheExample huangShiZheExample = new huangShiZheExample();
        huangShiZheExample.Criteria criteria = huangShiZheExample.createCriteria();
        criteria.andIdIsNotNull();
        List<huangShiZhe> L = hsz.selectByExample(huangShiZheExample);
        return new Gson().toJson(L);
    }

    @ResponseBody
    @RequestMapping("/zebra-dao")
    public String testAsync() {
        huangShiZhe g=hsz.selectByPrimaryKey(1);
        hsz.selectByPrimaryKey(1, new AsyncDaoCallback<huangShiZhe>() {
            @Override
            public void onSuccess(huangShiZhe huangShiZhe) {
                System.out.println(huangShiZhe == null);
                System.out.println(huangShiZhe.toString());
                System.out.println("===========================");
                System.out.println(huangShiZhe.getName() + " " + huangShiZhe.getSex());
            }

            @Override
            public void onException(Exception e) {
                System.out.println("o20CKp*?XZfp?");
            }
        });
        System.out.println(g.toString());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/future")
    public String selecetAll() {
        huangShiZheExample example = new huangShiZheExample();
        Future<List<huangShiZhe>> future = hsz.selectAll(example);
        String x = "";
        try {
            List<huangShiZhe> list = future.get();
            for (huangShiZhe h : list) {
                x += h.getName() + h.getSex() + h.getId();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return x;
    }
}
