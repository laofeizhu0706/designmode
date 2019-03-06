一．        单例模式 

二．        工厂模式 

三．        原型模式 

四．        生成器模式 

五．        适配器模式 

六．        装饰者模式 

七．        代理模式 

八．        外观模式 

九．        桥接模式 

十．        组合模式 

十一．        策略模式 

十二．        模板方法模式 

十三．        观察者模式 

十四．        迭代器模式 

十五．        解释器模式 

十六．        访问者模式 

十七．        命令模式 

十八．        备忘录模式 

十九．        责任链模式 

二十．        中介者模式 

二十一．        享元模式 

二十二．        状态模式 

# 一．单例模式

简介：单例模式可以保证系统中一个类只有一个实例。即一个类只有一个对象实例。

事例：

1. 懒汉模式：调用取得实例方法的时候才会实例化对象。

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/1

 \* msg: 懒汉模式

 \*/

public class LazySingleton {

    private static LazySingleton singleton;

    public static synchronized LazySingleton getInstance(){

        if(singleton==null){

            singleton = new LazySingleton();

        }

        return singleton;

    }

}

1. 饿汉模式：在单例类被加载时候，就实例化一个对象交给自己的引用

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/1

 \* msg: 饿汉模式

 \*/

public class HungrySingleton {

    private static final HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance(){

        return singleton;

    }

}

1. 枚举实现单例，利用枚举的特性实现单例又可以保证代码的优雅，又可以实现线程安全，但是这样创建却少了懒加载这一功能

public enum EnumSingleton {

    INSTANCE

}

1. 静态内部类单例实现：利用jvm的特性，内部类一开始不会被实例化，直到有某个静态成员被调用时才会被实例化。这解决了饿汉模式下的快加载，也解决了懒汉模式下的线程安全问题（建议使用该种方式）

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/1

 \* msg:

 \*/

public class InnerClassSingleton {

    public static class SingletonHolder {

        private static final InnerClassSingleton INSTANCE

=new InnerClassSingleton();

    }

    private InnerClassSingleton getSingleton() {

        return SingletonHolder.INSTANCE;

    }

}

1. 内部枚举实现单例：看起来不优雅。但却也做到了懒加载和线程安全的作用

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/1

 \* msg: 内部枚举类实现单例

 \*/

public class InnerEnumSingleton {

    private enum SingletonHolder {

        INSTANCE;

        private InnerEnumSingleton singleton;

        SingletonHolder() {

            singleton=new InnerEnumSingleton();

        }

        public InnerEnumSingleton getSingleton() {

            return singleton;

        }

    }

    public InnerEnumSingleton getSingleton() {

        return SingletonHolder.INSTANCE.getSingleton();

    }

}

场景：

1. 需要平凡实例化然后销毁的对象。
2. 创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
3. 资源共享的情况下，避免由于资源操作时导致的性能或损耗等
4. 控制资源的情况下，方便资源之间的互相通信。

# 二．工厂模式

简介：工厂模式主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。它提供了一种创建对象的最佳方式。

代码实例：

1. 简单工厂模式：也叫静态工厂

实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。

1. 工厂模式

工厂方法是粒度很小的设计模式，因为模式的表现只是一个抽象的方法。 提前定义用于创建对象的接口，让子类决定实例化具体的某一个类，即在工厂和产品中间增加接口，工厂不再负责产品的创建，由接口针对不同条件返回具体的类实例，由具体类实例去实现。

代码：

### 汽车接口 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/4

 \*/

public interface ICar {

    void getCar();

}

### 汽车类别 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/4

 \*/

public enum CarType {

    JEEP,//吉普車

    BMW//寶馬

}

### 宝马汽车实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/4

 \*/

public class BMWCar implements ICar {

    @Override

    public void getCar() {

        System.out.println(&quot;宝马车&quot;);

    }

}

### 吉普车实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/4

 \*/

public class JeepCar implements ICar{

    @Override

    public void getCar() {

        System.out.println(&quot;吉普车&quot;);

    }

}

### 工厂 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/4

 \*/

public class Factory {

    public ICar getCarByType(CarType type) {

        switch (type) {

            case BMW: return new BMWCar();

            case JEEP: return new JeepCar();

            default:return null;

        }

    }

}

/\*\*

 \* 简单工厂测试

 \*/

@Test

public void simagleFactoryTest() {

    Factory factory = new Factory();

    factory.getCarByType(CarType.BMW).getCar();

    factory.getCarByType(CarType.JEEP).getCar();

}

1. 抽象工厂模式

当有多个抽象角色时使用的一种工厂模式。抽象工厂模式可以向客户端提供一个接口，使客户端在不必指定产品的具体的情况下，创建多个产品对象。它有多个抽象产品类，每个抽象产品类可以派生出多个具体产品类，一个抽象工厂类，可以派生出多个具体工厂类，每个具体工厂类可以创建多个具体产品类的实例。

 好处：1. 你只要知道对象的名称就可以实例化他，这降低了耦合度。

    2. 屏蔽了具体实现，只要知道接口就可以了

    3. 扩展简单

坏处：1. 每增加一个产品，都需要创建一个对象以及他的工厂实现

        2. 在简单的实例使用这个模式，会产生很多冗余代码，也降低了复杂度

  应用场景：

1. 系统后期经常扩展
2. 一个对象拥有很多子类
3. 创建一个对象要有很多其他操作

# 三．原型模式

简介：通过复制现有的对象实例来创建新的对象实例，提高效率。

实现：Cloneable接口的作用是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。

代码实现：

### 事件类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \* msg: 不变事件信息

 \*/

@Data

public class Event {

    private String subject;

    private String content;

    public Event(String subject, String content) {

        this.subject = subject;

        this.content = content;

    }

}

### 邮件类，实现Cloneable ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \* msg: 发送邮件类

 \*/

@Data

public class Mail implements Cloneable {

    private String tail;

    private String receiver;

    private String subject;

    private String content;

    public Mail(Event event) {

        this.subject = event.getSubject();

        this.content = event.getContent();

    }

    @Override

    protected Mail clone() {

        Mail mail = null;

        try {

            mail = (Mail) super.clone();

        } catch (CloneNotSupportedException e) {

            e.printStackTrace();

        }

        return mail;

    }

    public void sendMail() {

        System.out.println(this.toString());

    }

    @Override

    public String toString() {

        return &quot;Mail{&quot; +

                &quot;tail=&#39;&quot; + tail + &#39;\&#39;&#39; +

                &quot;, receiver=&#39;&quot; + receiver + &#39;\&#39;&#39; +

                &quot;, subject=&#39;&quot; + subject + &#39;\&#39;&#39; +

                &quot;, content=&#39;&quot; + content + &#39;\&#39;&#39; +

                &#39;}&#39;;

    }

}

@Test

public void prototypeTest() {

    Event event=new Event(&quot;邀请信（变动参数）&quot;,&quot;张晓聪结婚了（不变参数）&quot;);

    Mail mail=new Mail(event);

    for (int i=0;i\&lt;9;i++) {

        Mail cloneMail = mail.clone();

        cloneMail.setTail(&quot;陈（变化参数）&quot;+i);

        cloneMail.setReceiver(&quot;134243919&quot;+i+&quot;@qq.com&quot;);

        cloneMail.sendMail();

    }

}

好处：

1. 使用原型模式比new一个对象更有效率，因为他是直接去操作内存中的二进制流，来完成的。

2. 使创建一个对象更简单，就像复制黏贴一样简单

坏处：

1. Object类的clone方法只会拷贝对象中的基本数据类型，对于数组，引用对象等只能另行拷贝。
2. 使用原型模式不能使用final对象

# 四．生成器模式

简介：将复杂的对象分离，使同样的构建过程，能有不同的表示

结构：

        Builder：生成器接口，定义创建一个Product对象所需要的各个部件的操作。

        ConcreteBuilder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，同时还提供一个让用户获取组装完成后的产品对象的方法。

        Director：指导者，也被称导向者，主要用来使用Builder接口，以一个统一的过程来构建所需要的Product对象。

        Product：产品，表示被生成器构建的复杂对象，包含多个部件。

代码实现：

### 每个设备都具有的特性 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

@Data

public class Device {

    private String name;

    private BigDecimal price;

    public Device(String name, BigDecimal price) {

        this.name = name;

        this.price = price;

    }

}

### 手机类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

@Data

public class Mobile extends Device {

    private String cpu;

    private String camera;

    public Mobile(String name, BigDecimal price, String cpu, String camera) {

        super(name, price);

        this.cpu = cpu;

        this.camera = camera;

    }

}

### 电脑 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

@Data

public class Computer extends Device {

    private String cpu;

    private String mem;

    public Computer(String name, BigDecimal price, String cpu, String mem) {

        super(name, price);

        this.cpu = cpu;

        this.mem = mem;

    }

}

### 建造者接口 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \* 设备生产接口

 \*/

public interface DeviceBuilder\&lt;T\&gt; {

    /\*\*

     \* 原型讨论

     \*/

    void doDiscussion();

    /\*\*

     \* 原型设计

     \*/

    void doDesign();

    /\*\*

     \* 生产

     \*/

    T doProduct();

}

### 电脑建造者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*

 \* 电脑建筑者

 \*/

public class ComputerBuilder implements DeviceBuilder\&lt;Computer\&gt; {

    @Override

    public void doDiscussion() {

        System.out.println(&quot;电脑原型讨论&quot;);

    }

    @Override

    public void doDesign() {

        System.out.println(&quot;电脑模型的设计&quot;);

    }

    @Override

    public Computer doProduct() {

        System.out.println(&quot;电脑生产者在生产&quot;);

        return new Computer(&quot;电脑&quot;,new BigDecimal(4999),&quot;amd 1600x&quot;,&quot;16 g&quot;);

    }

}

### 手机建造者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class MobileBuilder implements DeviceBuilder\&lt;Mobile\&gt; {

    @Override

    public void doDiscussion() {

        System.out.println(&quot;手机原型讨论&quot;);

    }

    @Override

    public void doDesign() {

        System.out.println(&quot;手机模型的设计&quot;);

    }

    @Override

    public Mobile doProduct() {

        System.out.println(&quot;手机生产者在生产&quot;);

        return new Mobile(&quot;手机&quot;,new BigDecimal(2999),&quot;骁龙855&quot;,&quot;4800万像素&quot;);

    }

}

### 指挥者(指挥建造者去建造) ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \* 指挥者

 \*/

public class Director {

    @Test

    public void builderTest() {

        DeviceBuilder deviceBuilder=new ComputerBuilder();

        deviceBuilder.doDesign();

        deviceBuilder.doDiscussion();

        deviceBuilder.doProduct();

        deviceBuilder=new MobileBuilder();

        deviceBuilder.doDesign();

        deviceBuilder.doDiscussion();

        Object mobile = deviceBuilder.doProduct();

        System.out.println(mobile);

    }

}

优点：

1. 建造者相对独立，易扩展
2. 使客户端不需要知道产品的组成细节

缺点：

未知

 使用场景：

需要生成一个产品对象有复杂的内部结构。每一个内部成分本身可以是对象，也可以使一个对象的一个组成部分。

# 五．适配器模式

简介：将一个类的接口转换成客户需要的接口。适配器模式使之前接口不兼容而不能一起工作的类，使其可以兼容一起工作

主要角色：

 目标(Target)角色：这就是所期待得到的接口，也就是这类的接口是符合我们要求的。

　　源(Adapee)角色：我们要使用的接口，但是这个接口不符合我们的要求，也就是现在需要适配的接口。

适配器(Adaper)角色：适配器类是适配器模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。

 代码实现：

  1.类适配器

### 源角色 ###

  /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Adaptee {

    public void specificRequest() {

        System.out.println(&quot;特殊请求&quot;);

    }

}

### 需求 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Target {

    void request();

}

### 适配器 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Adapter1 extends Adaptee implements Target {

    @Override

    public void request() {

        super.specificRequest();

    }

}

### 类适配器测试 ###

/\*\*

 \* 类适配器测试

 \*/

@Test

public void classAdapter() {

    Target target = new Adapter1();

    target.request();

}

### 对象适配器 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Adapter2 implements Target{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {

     this.adaptee=adaptee;

    }

    @Override

    public void request() {

        adaptee.specificRequest();

    }

}

### 对象适配器测试 ###

/\*\*

 \* 对象适配器

 \*/

@Test

public void objectAdapter() {

    /\*\*

     \* 通过对象委托完成

     \*/

    Target target = new Adapter2(new Adaptee());

    target.request();

}

优点：

1. 系统希望需要使用现有类，而此类不满足需求，可以使用适配器模式做更好的复用。
2. 实现适配器时可以自由的使用自己开发的功能，这实现了良好的扩展性

缺点：

1.         过多使用适配器会导致系统的凌乱

使用场景

1. 已存在的类不符合我们的需求
2. 对旧系统的类进行需求更改，但不更改其本类

# 六．装饰者模式

简介：  在不必改变原类文件和原类使用的继承的情况下，动态地扩展一个对象的功能。

       它是通过创建一个包装对象，也就是用装饰来包裹真实的对象来实现。

主要角色：

    抽象构件角色（Project）：给出一个接口，以规范准备接收附加责任的对象。

    具体构件角色（Employe）：定义一个将要接收附加责任的类。

    装饰角色（Manager）：持有一个构件对象的实例，并定义一个与抽象构件接口一致的接口。

具体装饰角色（ManagerA、ManagerB）：负责给构件对象&quot;贴上&quot;附加的责任。

 代码示例：

 ### 人物类（Manager） ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface People {

    void eat();

}

### 老人（具体装饰角色） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class OldPeople implements People {

    /\*\*

     \* 老人只要吃饭

     \*/

    @Override

    public void eat() {

        System.out.println(&quot;吃饭&quot;);

    }

}

### 新人（具体装饰角色） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class NewPeople implements People {

    private People people;

    public NewPeople(People people) {

        this.people = people;

    }

    @Override

    public void eat() {

        System.out.println(&quot;做饭&quot;);

        people.eat();

        System.out.println(&quot;洗碗&quot;);

    }

}

### 装饰者模式测试 ###

/\*\*

 \* 装饰者模式测试

 \*/

@Test

public void decorator() {

    /\*\*

     \* 老人只要吃饭就行

     \*/

    People oldPeople=new OldPeople();

    oldPeople.eat();

    System.out.println(&quot;-------------------------------&quot;);

    /\*\*

     \* 而新人不仅要有老人的特性还有新人应该做的事情

     \*/

    People newPeople=new NewPeople(oldPeople);

    newPeople.eat();

}

 优点：

1. 使用装饰者模式比使用继承更加灵活，因为它选择通过一种动态的方式来扩展一个对象的功能，在运行时可以选择不同的装饰器，从而实现不同的行为。
2. 通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。
3. 具体构件类与具体装饰类可以独立变化，他能是低耦合的。用户可以根据需要来增加新的具体构件类和具体装饰类，在使用时再对其进行各种组合，原有代码无须改变，符合&quot;开闭原则&quot;。

缺点：

1. 被多钟对象做装饰时，使对象变得复杂，排查也变的困难

使用场景：

1. 需要扩展一个类的功能，或给一个类添加附加职责。
2. 需要动态的给一个对象添加功能，这些功能可能不明确或者暂时的，可以随时很方便的动态撤销掉。
3. 需要增加由一些基本功能的排列组合而产生的非常大量的功能，从而使继承关系变的不现实。
4. 当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。

# 七．代理模式

简介：为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个对象不适合或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用

主要角色：

1. 1．抽象角色： 代理角色和真实角色需实现抽象角色
2. 2．真实角色： 真实存在的角色，是我们要引用的对象
3. 3．代理角色： 代理对象角色内部含有对真实对象的引用，从而可以操作真实对象，同时代理对象提供与真实对象相同的接口以便在任何时刻都能代替真实对象。同时，代理对象可以在执行真实对象操作时，附加其他的操作，相当于对真实对象进行封装。

代码实现：

1. 静态代理：

### 抽象角色 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface UserService {

    void queryUserList();

}

### 真实角色 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class UserServiceImpl implements UserService{

    @Override

    public void queryUserList() {

        System.out.println(&quot;查询业务&quot;);

    }

}

### 代理角色 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class UserPoxyService implements UserService {

    private UserService userServiceImpl;

    public UserPoxyService(UserService userServiceImpl) {

        this.userServiceImpl = userServiceImpl;

    }

    @Override

    public void queryUserList() {

        userServiceImpl.queryUserList();

        System.out.println(&quot;新需求&quot;);

    }

}

### 静态代理测试 ###

/\*\*

 \* 静态代理

 \*/

@Test

public void staticProxy() {

    UserService userServiceImpl=new UserServiceImpl();

    UserService userPoxyService = new UserPoxyService(userServiceImpl);

    userPoxyService.queryUserList();

}

1. 动态代理：

### 代理的处理者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class UserHandler implements InvocationHandler {

    private UserService userServiceImpl;

    public UserHandler(UserService userServiceImpl) {

        this.userServiceImpl = userServiceImpl;

    }

    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object obj=null;

        if(method.getName().equals(&quot;queryUserList&quot;)) {

            System.out.println(&quot;新业务&quot;);

            obj=method.invoke(userServiceImpl,args);

        }

        return obj;

    }

}

### 动态代理测试 ###

@Test

public void dynamicProxy() {

    UserService userServiceImpl=new UserServiceImpl();

    UserHandler userServiceHandler=new UserHandler(userServiceImpl);

    UserService userService = (UserService) Proxy

            .newProxyInstance(ClassLoader.getSystemClassLoader(),

                    new Class[]{UserService.class},

                    userServiceHandler);

    userService.queryUserList();

}

 好处： 业务类只需要关注业务逻辑本身，保证了业务类的重用性。这是代理的共有优点。 能够协调调用者和被调用者，在一定程度上降低了系统的耦合度。

 应用场景：对于老项目的以有实现做扩展，不改变其原来本质

# 八．外观模式

简介：为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

代码示例：

 ### 子系统1 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class SubSystem1 {

    public void menthod() {

        System.out.println(&quot;方法1&quot;);

    }

}

### 子系统2 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class SubSystem2 {

    public void menthod() {

        System.out.println(&quot;方法2&quot;);

    }

}

### 子系统3 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class SubSystem3 {

    public void menthod() {

        System.out.println(&quot;方法3&quot;);

    }

}

### 父系统 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class BigSystem {

    public void menthod() {

        new SubSystem1().menthod();

        new SubSystem2().menthod();

        new SubSystem3().menthod();

    }

}

### 测试 ###

/\*\*

 \* 外观模式测试（相当于封装，让系统层的调用更清晰）

 \*/

@Test

public void facadeTest() {

    BigSystem bigSystem = new BigSystem();

    bigSystem.menthod();

}

 优点：实现了子系统与客户端之间的松耦合关系。客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。

 使用场景：

1. 开发阶段，子系统越来越复杂，增加外观模式提供一个简单的调用接口。
2. 设计初期阶段，应该有意识的将不同层分离，层与层之间建立外观模式。
3. 对某些非常难维护和扩展的旧系统，但其功能又是必须的，应该提供一个外观接口，使其变的更清晰

# 九．桥接模式

简介： 将抽象部分与实现部分分离，使它们都可以独立的变化。桥接模式是一种结构式模式。

代码示例：

 ### 操作接口 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Implementor {

    void operationImpl();

}

 ### 抽象服务类 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class AbstractionService {

    private Implementor implementor;

    public AbstractionService(Implementor implementor) {

        this.implementor = implementor;

    }

    /\*\*

     \* 其他操作

     \*/

    public abstract void otherOperation();

    /\*\*

     \* 操作

     \*/

    public void operation() {

        implementor.operationImpl();

    }

}

### 实现独立业务 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ServiceImpl1 implements Implementor {

    /\*\*

     \* 操作

     \*/

    @Override

    public void operationImpl() {

        System.out.println(&quot;业务1的操作&quot;);

    }

}

### 实现独立业务 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ServiceImpl2 implements Implementor {

    /\*\*

     \* 操作

     \*/

    @Override

    public void operationImpl() {

        System.out.println(&quot;业务2的操作&quot;);

    }

}

 ### 实现其他业务公共业务 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Service extends AbstractionService {

    public Service(Implementor implementor) {

        super(implementor);

    }

    @Override

    public void otherOperation() {

        System.out.println(&quot;其他业务&quot;);

    }

}

### 测试 ###

/\*\*

 \* 桥接模式测试

 \*/

@Test

public void bridgeTest() {

    Implementor impl=new ServiceImpl2();

    AbstractionService service=new Service(impl);

    service.operation();

    service.otherOperation();

}

 优点：

1. 将固定业务和非固定业务做一次抽象处理，减少了系统复杂程度，也增加了复用性

场景：

1. 当有公共业务又有独立业务的时候，可以考虑采用这种模式实现
2. 如果希望实现部分的修改，不会对客户产生影响，可以采用桥接模式，客户是面向抽象的接口在运行。
3. 实现部分的修改，可以独立于抽象部分，也就不会对客户产生影响了，也可以说对客户是透明的。

# 十．组合模式

简介：组合模式又叫做部分-整体模式,它使我们树型结构的问题中,模糊了简单元素和复杂元素的概念，客户程序可以向处理简单元素一样来处理复杂元素,从而使得客户程序与复杂元素的内部结构解藕。组合模式可以优化处理递归或分级数据结构.有许多关于分级数据结构的例子，使得组合模式非常有用武之地。

代码实例：

 ### 文件和文件夹公共类 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

@Data

public abstract class FolderComponent {

    private String name;

    public FolderComponent(String name) {

        this.name = name;

    }

    public abstract void add(FolderComponent component);

    public abstract void remove(FolderComponent component);

    public abstract void display();

}

### 文件 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class FileLeaf extends FolderComponent {

    public FileLeaf(String name) {

        super(name);

    }

    @Override

    public void add(FolderComponent component) {

    }

    @Override

    public void remove(FolderComponent component) {

    }

    @Override

    public void display() {

        System.out.println(&quot;File name is &quot;+this.getName());

    }

}

### 文件夹 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class FolderComposite extends FolderComponent {

    private List\&lt;FolderComponent\&gt; components=new ArrayList\&lt;\&gt;();

    public FolderComposite(String name) {

        super(name);

    }

    @Override

    public void add(FolderComponent component) {

        components.add(component);

    }

    @Override

    public void remove(FolderComponent component) {

        components.remove(component);

    }

    @Override

    public void display() {

        System.out.println(&quot;Folder name is &quot; + this.getName());

        for (FolderComponent component:

        components) {

            System.out.println(&quot;File of &quot;+this.getName()+&quot;&#39;Folder name is &quot;+component.getName());

        }

    }

}

### 测试方法 ###

@Test

public void componentTest() {

    FolderComponent leaf = new FileLeaf(&quot;8PM.mp3&quot;);

    leaf.display();

    FolderComponent folder = new FolderComposite(&quot;电影&quot;);

    folder.add(new FileLeaf(&quot;疯狂的外星人&quot;));

    folder.add(new FileLeaf(&quot;飞驰人生&quot;));

    folder.display();

}

 使用场景：

1. 1．表现对象的部分-整体层次结构
2. 2．希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。（摘抄）

# 十一．策略模式

简介：定义一组算法，将每个算法都封装起来，并且使他们之间可以互换。

比如TreeSet，我们都知道他是一个可以排序的set，而排序规则他又是怎么判断的呢？我们通常如果要改变他的排序规则，我们是不是应该实现Comparator接口来定义排序的规则？而Comparator是一个抽象策略，实现Comparator就是具体策略。

主要角色：

1. 封装类：也叫上下文，对策略进行二次封装，目的是避免高层模块对策略的直接调用。
2. 抽象策略：通常情况下为一个接口，当各个实现类中存在着重复的逻辑时，则使用抽象类来封装这部分公共的代码，此时，策略模式看上去更像是模版方法模式。
3. 具体策略：实现抽象策略，定义自己的策略

代码实例：

 ### 抽象策略 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface IStrategy {

    void doSomething();

}

### 具体策略1 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteStrategy1 implements IStrategy {

    @Override

    public void doSomething() {

        System.out.println(&quot;具体策略1&quot;);

    }

}

### 具体策略2 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteStrategy1 implements IStrategy {

    @Override

    public void doSomething() {

        System.out.println(&quot;具体策略1&quot;);

    }

}

### 封装类（提供处理方法） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {

        this.strategy = strategy;

    }

    public void execute() {

        strategy.doSomething();

    }

}

### 测试 ###

@Test

public void strategyTest() {

    Context context = new Context(new ConcreteStrategy1());

    context.execute();

    context = new Context(new ConcreteStrategy2());

    context.execute();

    TreeSet\&lt;String\&gt; treeSet=new TreeSet\&lt;\&gt;();

}

# 十二．模板方法模式

简介：定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该算法中的某些特定步骤。

代码实例：

### 抽象类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class AbstractSort {

    public abstract void sort(int[] arrs);

    /\*\*

     \* 打印数组

     \* @param arrs

     \*/

    public void printSortArrary(int[] arrs) {

        this.sort(arrs);

        System.out.println(Arrays.toString(arrs));

    }

}

### 具体实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteSort extends AbstractSort {

    @Override

    public void sort(int[] arrs) {

        this.sort(arrs,0,arrs.length-1);

    }

    public void sort(int[] a,int low,int high){

        int start = low;

        int end = high;

        int key = a[low];

        while(end\&gt;start){

            //从后往前比较

            while(end\&gt;start&amp;&amp;a[end]\&gt;=key)  {

                end--;//如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较

            }

            if(a[end]\&lt;=key){

                int temp = a[end];

                a[end] = a[start];

                a[start] = temp;

            }

            //从前往后比较

            while(end\&gt;start&amp;&amp;a[start]\&lt;=key){//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置

                start++;

            }

            if(a[start]\&gt;=key){

                int temp = a[start];

                a[start] = a[end];

                a[end] = temp;

            }

            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用

        }

        //递归

        if(start\&gt;low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1

        if(end\&lt;high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个

    }

}

### 测试 ###

@Test

public void templateTest() {

    int[] arrs=new int[]{1,5,4,3,2};

    AbstractSort sort=new ConcreteSort();

    sort.printSortArrary(arrs);

}

应用场景：假如安排职员a做出一个数组排序的方法并打印，但是职员a并不会排序算法，刚好职员b说他会，这是职员a采用这种设计模式，就可以轻松完成自己的业务。一般抽象类的实现类由有经验的人实现，也是最重要的方法。

# 十三．观察者模式

简介：定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。

主要实现对象：

 抽象观察者：提供抽象update方法

 具体的观察者：实现update方法，在被观察者的状态发生变化而触发update方法

 抽象被观察者：提供一个队列，提供入队、出队等操作，以及触发观察者的方法

 被观察者实现类：可以编写自己的一些逻辑

代码实例：

 ### 抽象类观察者 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Observer {

    void update();

}

### 具体观察者1 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ObserverImpl1 implements Observer {

    @Override

    public void update() {

        System.out.println(&quot;观察者1收到消息，正在更新&quot;);

    }

}

### 具体观察者2 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ObserverImpl2 implements Observer {

    @Override

    public void update() {

        System.out.println(&quot;观察者2收到消息，正在更新&quot;);

    }

}

### 抽象类被观察者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class AbstractSubject {

    public BlockingQueue\&lt;Observer\&gt; observers=new LinkedBlockingDeque\&lt;\&gt;();

    public void addObserver(Observer observer) {

        this.observers.offer(observer);

    }

    public void removeObserver(Observer observer) {

        this.observers.remove(observer);

    }

    protected void updateObservers() {

        /\*\*

         \* 使用并行处理业务

         \*/

        observers.parallelStream().forEach(observer -\&gt; observer.update());

    }

    public abstract void doSomething();

}

### 观察者具体实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteSubject extends AbstractSubject {

    @Override

    public void doSomething() {

        /\*\*

         \* 观察者被事件触发，处理各自业务，以及整体任务

         \*/

        System.out.println(&quot;其他业务&quot;);

        super.updateObservers();

    }

}

### 测试方法 ###

@Test

public void observerTest() {

    AbstractSubject subject=new ConcreteSubject();

    subject.addObserver(new ObserverImpl2());

    subject.addObserver(new ObserverImpl1());

    subject.addObserver(new ObserverImpl2());

    subject.doSomething();

}

应用场景：假如一个订单的产生，库存数量需要改变，也需要给商家发送信息，可以使用观察者模式设计，将库存和商家发送信息设置成观察者，由于订单的产生，观察者通过被观察者，触发了自己的方法（这种模式类似发布订阅）

# 十四．迭代器模式

简介：提供一种方法访问一个容器对象中各个元素，而又不暴露该对象的内部细节。

代码实现：

 ### 迭代器模型 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Iterator\&lt;T\&gt; {

    boolean hasHash();

    T next();

}

### 迭代器实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteIterator\&lt;T\&gt; implements Iterator\&lt;T\&gt; {

    private List\&lt;T\&gt; list;

    private  int cursor=0;

    public ConcreteIterator(List\&lt;T\&gt; list) {

        this.list = list;

    }

    @Override

    public boolean hasHash() {

        if(cursor==list.size()) {

            return false;

        }

        return true;

    }

    @Override

    public T next() {

        T obj=null;

        if(this.hasHash()) {

            obj=this.list.get(cursor++);

        }

        return obj;

    }

}

### 集合 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Aggregate\&lt;T\&gt; {

    void add(T obj);

    void remove(T obj);

    Iterator\&lt;T\&gt; iterator();

}

### 集合实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteAggregate\&lt;T\&gt; implements Aggregate\&lt;T\&gt; {

    private List\&lt;T\&gt; list=new ArrayList\&lt;\&gt;();

    @Override

    public void add(T obj) {

        list.add(obj);

    }

    @Override

    public void remove(T  obj) {

        list.remove(obj);

    }

    @Override

    public Iterator iterator() {

        return new ConcreteIterator\&lt;T\&gt;(list);

    }

}

### 测试 ###

/\*\*

 \* 迭代模式测试

 \*/

@Test

public void lteratorTest() {

    Aggregate\&lt;String\&gt; aggregate=new ConcreteAggregate\&lt;\&gt;();

    aggregate.add(&quot;张晓聪&quot;);

    aggregate.add(&quot;小蓝&quot;);

    aggregate.add(&quot;涂松凯&quot;);

    Iterator iterator = aggregate.iterator();

    while (iterator.hasHash()) {

        String obj = (String) iterator.next();

        System.out.println(obj);

    }

}

简单的实现迭代器

# 十五．解释器模式

简介：给定一种语言，定义他的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中句子。

主要对象：

 抽象解释器：一般是接口，提供解释的抽象方法

 终结符表达式实现类：实现具体的业务

 非终结符表达式实现类：

代码实现：

### 解释器抽象类 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface INode {

    int interpret();

}

### 终结表达式抽象类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

@Getter

public abstract class SymbolNode implements INode {

    private INode left;

    private INode right;

    public SymbolNode(INode left, INode right) {

        this.left = left;

        this.right = right;

    }

}

### 终结表达式实现类（求余数） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ModNode extends SymbolNode {

    public ModNode(INode left, INode right) {

        super(left, right);

    }

    @Override

    public int interpret() {

        return super.getLeft().interpret()%super.getRight().interpret();

    }

}

### 终结表达式实现类（除法） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class DivNode extends SymbolNode {

    public DivNode(INode left, INode rigth) {

        super(left, rigth);

    }

    @Override

    public int interpret() {

        return super.getLeft().interpret()/super.getRight().interpret();

    }

}

### 终结表达式实现类（乘法） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class MulNode extends SymbolNode {

    public MulNode(INode left, INode rigth) {

        super(left, rigth);

    }

    @Override

    public int interpret() {

        return super.getLeft().interpret()\*super.getRight().interpret();

    }

}

### 非终结表达式 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \* 数字的节点，表示非终结表达式

 \*/

public class NumberNode implements INode {

    private int value;

    public NumberNode(int value) {

        this.value = value;

    }

    @Override

    public int interpret() {

        return this.value;

    }

}

### 处理终结表达式和非终结表达式的关系 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Calculator {

    private INode node;

    public void build(String statement) {

        INode left=null,right=null;

        char[] symbols = statement.trim().toCharArray();

        Stack\&lt;INode\&gt; stack = new Stack\&lt;\&gt;();

        for (int i = 0; i \&lt; symbols.length; i++) {

            String symbol = Character.toString(symbols[i]);

            if(symbol.equalsIgnoreCase(&quot;\*&quot;)) {

                left=stack.pop();

                int val = Integer.parseInt(Character.toString(symbols[++i]));

                right = new NumberNode(val);

                stack.push(new MulNode(left,right));

            } else if(symbol.equalsIgnoreCase(&quot;/&quot;)) {

                left=stack.pop();

                int val = Integer.parseInt(Character.toString(symbols[++i]));

                right = new NumberNode(val);

                stack.push(new DivNode(left,right));

            } else if(symbol.equalsIgnoreCase(&quot;%&quot;)) {

                left=stack.pop();

                int val = Integer.parseInt(Character.toString(symbols[++i]));

                right = new NumberNode(val);

                stack.push(new ModNode(left,right));

            } else {

                stack.push(new NumberNode(Integer.parseInt(symbol)));

            }

        }

        this.node=stack.pop();

    }

    public int getResult() {

        return this.node.interpret();

    }

}

### 测试类 ###

/\*\*

 \* 解释器模式测试

 \*/

@Test

public void InterpreterTest() {

    Calculator calculator=new Calculator();

    calculator.build(&quot;2\*4/2%2&quot;);

    int result = calculator.getResult();

    System.out.println(result);

}

  应用场景：

1. 计算器的公式解析
2. Sql语句的解释

# 十六．访问者模式

简介：封装某些作用于某种数据结构中各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。

主要组成对象：

代码实现：

 ### 抽象访问者 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface IVisitor {

    void visit(ConcreteElement1 element1);

    void visit(ConcreteElement2 element2);

}

### 抽象元素 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class Element {

    public abstract void accept(IVisitor visitor);

    public abstract void doSomething();

}

### 元素1的实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteElement1 extends Element {

    @Override

    public void accept(IVisitor visitor) {

        visitor.visit(this);

    }

    @Override

    public void doSomething() {

        System.out.println(&quot;这是访问者2&quot;);

    }

}

### 元素2的实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteElement2 extends Element {

    @Override

    public void accept(IVisitor visitor) {

        visitor.visit(this);

    }

    @Override

    public void doSomething() {

        System.out.println(&quot;这是访问者1&quot;);

    }

}

### 访问者实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Visitor implements IVisitor {

    @Override

    public void visit(ConcreteElement1 element1) {

        element1.doSomething();

    }

    @Override

    public void visit(ConcreteElement2 element2) {

        element2.doSomething();

    }

}

### 结构对象 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ObjectStruture {

    public List\&lt;Element\&gt; getList() {

        List\&lt;Element\&gt; list = new ArrayList\&lt;Element\&gt;();

        Random ran = new Random();

        for(int i=0; i\&lt;10; i++){

            int a = ran.nextInt(100);

            if(a\&gt;50){

                list.add(new ConcreteElement1());

            }else{

                list.add(new ConcreteElement2());

            }

        }

        return list;

    }

}

 ### 测试 ###

@Test

public void visitorTest() {

    List\&lt;Element\&gt; list = new ObjectStruture().getList();

    IVisitor visitor = new Visitor();

    for (Element element:

         list) {

        element.accept(visitor);

    }

}

应用场景：

1. 假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，则可以使用访问者模式来把这些操作封装到访问者中去。
2. 假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，也可以将这些重复的操作封装到访问者中去。

# 十七．命令模式

简介：将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

主要组成对象：

Command类：是一个抽象类，类中对需要执行的命令进行声明，一般来说要对外公布一个execute方法用来执行命令。

ConcreteCommand类：Command类的实现类，对抽象类中声明的方法进行实现。

Invoker类：调用者，负责调用命令。

Receiver类：接收者，负责接收命令并且执行命令。

代码实现：

 ### 命令接口 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface Command {

    /\*\*

     \* 执行命令

     \*/

    void execute();

}

### 命令实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){

        this.receiver = receiver;

    }

    /\*\*

     \* 命令执行，让执行者去执行命令

     \*/

    @Override

    public void execute() {

        receiver.doSomething();

    }

}

### 命令调用者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Invoker {

    private Command command;

    public void setCommand(Command command) {

        this.command = command;

    }

    public void action(){

        this.command.execute();

    }

}

### 命令执行者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Receiver {

    public void doSomething() {

        System.out.println(&quot;命令接收者&quot;);

    }

}

### 测试 ###

/\*\*

 \* 测试命令模式

 \*/

@Test

public void testCommand() {

    ConcreteCommand command = new ConcreteCommand(new Receiver());

    command.execute();

    Invoker invoker=new Invoker();

    invoker.setCommand(command);

    invoker.action();

}

应用场景：

对于大多数请求和响应模式的功能，比较适合使用命令模式，正如命令模式定义说的那样，命令模式对实现记录日志、撤销操作等功能比较方便。

# 十八．备忘录模式

简介：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样就可以将该对象恢复到原先保存的状态。

主要组成对象：

发起人：记录当前时刻的内部状态，负责定义哪些属于备份范围的状态，负责创建和恢复备忘录数据。

备忘录：负责存储发起人对象的内部状态，在需要的时候提供发起人需要的内部状态。

管理角色：对备忘录进行管理，保存和提供备忘录

代码实现：

### 备忘录类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Memento {

    private String state = &quot;&quot;;

    public Memento(String state){

        this.state = state;

    }

    public String getState() {

        return state;

    }

    public void setState(String state) {

        this.state = state;

    }

}

### 备忘录管理类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Caretaker {

    private Memento memento;

    public Memento getMemento() {

        return memento;

    }

    public void setMemento(Memento memento) {

        this.memento = memento;

    }

}

### 发起人 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Originator {

    private String state = &quot;&quot;;

    public String getState() {

        return state;

    }

    public void setState(String state) {

        this.state = state;

    }

    public Memento createMemento(){

        return new Memento(this.state);

    }

    public void restoreMemento(Memento memento){

        this.setState(memento.getState());

    }

}

### 测试 ###

/\*\*

 \* 备忘录模式(crtl + z原理)

 \*/

@Test

public void MemoTest() {

    Originator originator = new Originator();

    originator.setState(&quot;状态1&quot;);

    System.out.println(&quot;初始状态:&quot;+originator.getState());

    Caretaker caretaker = new Caretaker();

    caretaker.setMemento(originator.createMemento());

    originator.setState(&quot;状态2&quot;);

    System.out.println(&quot;改变后状态:&quot;+originator.getState());

    originator.restoreMemento(caretaker.getMemento());

    System.out.println(&quot;恢复后状态:&quot;+originator.getState());

}

应用场景：

保存上一个状态，使系统具有恢复性

# 十九．责任链模式

简介：使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

主要组成对象：

抽象处理类：抽象处理类中主要包含一个指向下一处理类的成员变量nextHandler和一个处理请求的方法handRequest，handRequest方法的主要主要思想是，如果满足处理的条件，则有本处理类来进行处理，否则由nextHandler来处理。

具体处理类：具体处理类主要是对具体的处理逻辑和处理的适用条件进行实现。

代码实现：

### 级别 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Level {

    private int level = 0;

    public Level(int level){

        this.level = level;

    }

    public boolean above(Level level){

        if(this.level \&gt;= level.level){

            return true;

        }

        return false;

    }

}

### Response ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Response {

}

### request级别 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Request {

    Level level;

    public Request(Level level) {

        this.level = level;

    }

    public Level getLevel() {

        return level;

    }

}

### 抽象处理类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class Handler {

    private Handler nextHandler;

    public final Response handleRequest(Request request) {

        Response response = null;

        if (this.getHandlerLevel().above(request.getLevel())) {

            response = this.response(request);

        } else {

            if (this.nextHandler != null) {

                this.nextHandler.handleRequest(request);

            } else {

                System.out.println(&quot;-----没有合适的处理器-----&quot;);

            }

        }

        return response;

    }

    public void setNextHandler(Handler handler) {

        this.nextHandler = handler;

    }

    protected abstract Level getHandlerLevel();

    public abstract Response response(Request request);

}

### 具体处理实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteHandler1 extends Handler {

    protected Level getHandlerLevel() {

        return new Level(1);

    }

    public Response response(Request request) {

        System.out.println(&quot;-----请求由处理器1进行处理-----&quot;);

        return null;

    }

}

### 具体处理实现类2 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteHandler2 extends Handler {

    protected Level getHandlerLevel() {

        return new Level(3);

    }

    public Response response(Request request) {

        System.out.println(&quot;-----请求由处理器2进行处理-----&quot;);

        return null;

    }

}

### 具体处理实现类3 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteHandler3 extends Handler {

    protected Level getHandlerLevel() {

        return new Level(5);

    }

    public Response response(Request request) {

        System.out.println(&quot;-----请求由处理器3进行处理-----&quot;);

        return null;

    }

}

### 测试 ###

/\*\*

 \* 责任链模式测试方法

 \*/

@Test

public void chainTest() {

    Handler handler1 = new ConcreteHandler1();

    Handler handler2 = new ConcreteHandler2();

    Handler handler3 = new ConcreteHandler3();

    handler1.setNextHandler(handler2);

    handler2.setNextHandler(handler3);

    Response response = handler1.handleRequest(new Request(new Level(4)));

}

应用场景：灵活版的ifelse

# 二十．中介者模式

简介：用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使耦合松散，而且可以独立地改变它们之间的交互。

主要组成对象：

 中介者：做中介关系

 会互相影响的对象：可以是同事之间的关系

代码实现：

 ### 同事的抽象类 ###

 /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class AbstractColleague {

    protected int number;

    public int getNumber() {

        return number;

    }

    public void setNumber(int number) {

        this.number = number;

    }

    public abstract void setNumber(int number, AbstractMediator am);

}

### 同事a ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteColleagueA extends AbstractColleague {

    public void setNumber(int number, AbstractMediator am) {

        this.number = number;

        am.AaffectB();

    }

}

### 同事b ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteColleagueB extends AbstractColleague {

    public void setNumber(int number, AbstractMediator am) {

        this.number = number;

        am.BaffectA();

    }

}

### 抽象中介者 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public abstract class AbstractMediator {

    protected AbstractColleague A;

    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {

        A = a;

        B = b;

    }

    public abstract void AaffectB();

    public abstract void BaffectA();

}

### 中介者实现类 ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteMediator extends AbstractMediator {

    public ConcreteMediator(AbstractColleague a, AbstractColleague b) {

        super(a, b);

    }

    @Override

    public void AaffectB() {

        B.setNumber(A.getNumber()\*100);

    }

    @Override

    public void BaffectA() {

        A.setNumber(B.getNumber()/100);

    }

}

### 测试方法 ###

/\*\*

 \* 中介者模式（当互相影响的时候，可以使用）

 \*/

@Test

public void IntermediaryTest() {

    AbstractColleague collA = new ConcreteColleagueA();

    AbstractColleague collB = new ConcreteColleagueB();

    /\*\*

     \* 中间者，通过中间者去改变

     \*/

    AbstractMediator am = new ConcreteMediator(collA, collB);

    System.out.println(&quot;==========通过设置A影响B==========&quot;);

    collA.setNumber(1000, am);

    System.out.println(&quot;collA的number值为：&quot;+collA.getNumber());

    System.out.println(&quot;collB的number值为A的10倍：&quot;+collB.getNumber());

    System.out.println(&quot;==========通过设置B影响A==========&quot;);

    collB.setNumber(1000, am);

    System.out.println(&quot;collB的number值为：&quot;+collB.getNumber());

    System.out.println(&quot;collA的number值为B的0.1倍：&quot;+collA.getNumber());

}

应用场景：

1. 使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
2. 易处理对象间的相互影响

# 二十一．享元模式

简介：

主要组成对象：

代码实现：

应用场景：

# 二十二．状态模式

简介：当系统中某个对象存在多个状态，这些状态之间可以进行转换，而且对象在不同状态下行为不相同时可以使用状态模式。状态模式将一个对象的状态从该对象中分离出来，封装到专门的状态类中，使得对象状态可以灵活变化。状态模式是一种对象行为型模式。

主要组成对象：

抽象状态类：在抽象状态类中定义申明了不同状态下的行为抽象方法，而由子类(不同的状态子类)中实现不同的行为操作。

状态实现类：抽象状态类的子类，每一个子类实现一个与环境类(Context)的一个状态相关的行为，每一个具体的状态类对应环境的一种具体状态，不同的具体状态其行为有所不同。

拥有状态对象的环境类：拥有状态属性，因环境的多样性，它可拥有不同的状态，且在不同状态下行为也不一样。在环境类中维护一个抽象的状态实例，这个实例定义当前环境的状态(setState()方法)，而将具体的状态行为分离出来由不同的状态子类去完成。

代码实现：

### 状态类 ###

    /\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public interface State {

    void behavior();

}

### 状态B  ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteStateB implements State {

    @Override

    public void behavior() {

        System.out.println(&quot;话费高于0，可以打电话&quot;);

    }

}

### 状态A  ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class ConcreteStateA implements State {

    @Override

    public void behavior() {

        System.out.println(&quot;话费低于0，不能打电话&quot;);

    }

}

### 环境类（随环境的变化而发送状态的改变） ###

/\*\*

 \* @author 老肥猪

 \* @since 2019/3/2

 \*/

public class Context {

    private State state;

    @Getter

    @Setter

    private BigDecimal bill;

    public void handle() {

        check();

        this.state.behavior();

    }

    private void check() {

        if(this.bill.compareTo(new BigDecimal(0))\&gt;0) {

            this.state=new ConcreteStateB();

        }else {

            this.state=new ConcreteStateA();

        }

    }

}
### 测试方法 ###

/\*\*

 \* 状态模式测试

 \*/

@Test

public void stateTest() {

    Context context = new Context();

    context.setBill(new BigDecimal(100));

    System.out.println(&quot;当前花费：&quot;+context.getBill()+&quot;元&quot;);

    context.handle();

    context.setBill(new BigDecimal(0));

    System.out.println(&quot;当前花费：&quot;+context.getBill()+&quot;元&quot;);

    context.handle();

    context.setBill(new BigDecimal(50));

    System.out.println(&quot;当前花费：&quot;+context.getBill()+&quot;元&quot;);

    context.handle();

}

应用场景：

用于解决系统中复杂对象的多种状态转换以及不同状态下行为的封装问题。简单说就是处理对象的多种状态及其相互转换。