package lyf.litespring.bean.factory.support;

import lyf.litespring.bean.BeanDefinition;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午11:15 18-8-21
 * @Modified By:
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName(){
        return this.beanClassName;
    }
}
