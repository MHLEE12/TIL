package mhspring.helloboot;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {
    String sayHello(String name);

    default int countOf(String name){
        return 0;
    }
}
