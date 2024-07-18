package factory;

import service.BlogService;
import service.UserService;

public class ServiceFactory {

    public IService createService(String type){
        if(type == null){
            return null;
        }

        if (type.equalsIgnoreCase("blog")){
            return new BlogService();
        } else if (type.equalsIgnoreCase("user")) {
            return new UserService();
        } else{
            throw new RuntimeException("Servis bulunamadı");
        }



    }

}
