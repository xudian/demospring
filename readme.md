# IOC容器
## 1、step1-最基本的容器信息
    1、Ioc最基本的角色，容器(BeanFactory)和bean本身。使用BeanDefine来封装bean对象，可以存储一些额外的信息.
   
    
## 2、step2-将bean的创建放入到工厂
    1、step1中的bean是初始化后，再放入到工厂中，我们希望是容器来管理bean。所以bean的初始化需要放入到BeanFactory中。
    为了后续的扩展性，需要将BeanFactory扩展为接口，AbstractBeanFactory和AutowireCapableBeanFactory作为其实现。
  
        
## 3、step3-为bean注入属性
    为bean注入属性.将属性注入信息保存成PropertyValue对象，并且保存到BeanDefinition中。
    这样在初始化bean的时候，就可以根据PropertyValue来进行bean属性的注入。
    Spring本身使用了setter来进行注入，这里为了代码简洁，使用Field的形式来注入。
    
## 4、step4-读取xml配置文件来初始化bean
    BeanDefinition定义一些配置信息,定义BeanDefinitionReader来初始化bean,它有一个实现是XmlBeanDefinitionReader。
    
## 5、step5-在bean中注入bean

## 6、step6-引入ApplicationContext

## 7、step7--使用JDK动态代理实现AOP织入
    Spring AOP的织入点是AopProxy，它包含一个方法Object getProxy()来获取代理后的对象。
    在Spring AOP中，最重要的两个角色，就是MethodInterceptor和MethodInvocation（这两个角色都是AOP联盟的标准），
    它们分别对应AOP中两个基本角色：Advice和Joinpoint。Advice定义了在切点指定的逻辑，而Joinpoint则代表切点。
    Spring的AOP只支持方法级别的调用，所以其实在AopProxy里，我们只需要将MethodInterceptor放入对象的方法调用即可。
    被代理对象为TargetSource，而AdvisedSupport就是保存TargetSource和MethodInterceptor的元数据对象。
    这一步先实现一个基于JDK动态代理的JdkDynamicAopProxy，它可以对接口进行代理。于是我们就有了基本的织入功能。
    
              
## 8.step8-使用AspectJ管理切面
    完成了织入之后，我们要考虑另外一个问题：对什么类以及什么方法进行AOP？对于“在哪切”这一问题的定义，我们又叫做“Pointcut”。
    Spring中关于Pointcut包含两个角色：ClassFilter和MethodMatcher，分别是对类和方法做匹配。
    Pointcut有很多种定义方法，例如类名匹配、正则匹配等，但是应用比较广泛的应该是和AspectJ表达式的方式。
    
## 9、step9-将AOP融入Bean的创建过程
    