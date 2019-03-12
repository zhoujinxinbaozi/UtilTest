package spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的执行顺序是 构造方法->初始化之前(postProcessBeforeInitialization)->初始化方法->初始化之后(postProcessAfterInitialization)
 *                 ->业务逻辑方法->销毁方法(destroy)
 */
public class InitHello implements BeanPostProcessor {

    // 实例化的当前的bean，bean的名称(默认首字母小写)
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        if(beanName.equalsIgnoreCase("helloworld")){
            System.out.println(" BeforeInitialization helloword ");
        }else if(beanName.equalsIgnoreCase("helloworld1")){
            System.out.println(" BeforeInitialization helloworld1 ");
//            System.out.println( "bbb" + ((HelloWorld1)bean).getText());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        if(beanName.equalsIgnoreCase("helloworld")){
            System.out.println(" AfterInitialization helloword ");
        }else if(beanName.equalsIgnoreCase("helloworld1")){
            System.out.println(" AfterInitialization helloword1 ");
        }
        return bean;
    }
}
