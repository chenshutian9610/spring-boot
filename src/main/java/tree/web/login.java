package tree.web;

import tree.dao.UserDao;
import tree.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class login {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/select")
    public String select(@RequestParam(defaultValue = "0") int id, Model model){
        if(id==0){
            List<User> users=userDao.getAll();
            model.addAttribute("result",users);
        }else{
            User one=userDao.getOne(id);
            List<User>result=new LinkedList<User>();
            result.add(one);
            model.addAttribute("result",result);
        }
        return "index";
    }
    @RequestMapping("/manage")
    public String manage(User user,String submit,Model model){
        int n=0;
        if(submit.equals("insert"))
            try{n=userDao.insertOne(user);} catch(Exception e){n=0;}
        System.out.println(n);
        String msg=n==1?"success":"fail";
        model.addAttribute("msg",msg);
        return "management";
    }
}
