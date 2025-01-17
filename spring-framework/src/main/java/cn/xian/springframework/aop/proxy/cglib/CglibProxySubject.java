//package cn.xian.springframework.aop.proxy.cglib;
//
//import lombok.extern.slf4j.Slf4j;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//
//
///**
// * cglib通过生成子类来实现动态代理
// *
// * @author lishixian
// * @date 2020/7/11 下午8:52
// */
//@Slf4j
//public class CglibProxySubject {
//
//    /**
//     * @param realSubjectClazz 真实主体，目标主体类
//     * @param <T>              真实主体，目标主体类
//     * @return 真实主体，目标主体类的代理对象
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T createProxy(Class<T> realSubjectClazz) {
//
//        Enhancer enhancer = new Enhancer();
//        // 代理类的父类，即：被代理类
//        enhancer.setSuperclass(realSubjectClazz);
//        // 代理类增强的方法
//        MethodInterceptor methodInterceptor = (obj, method, args, proxy) -> {
//            log.info("cglib动态代理.......开启事务");
//            try {
//                // 执行被代理的方法
//                Object result = proxy.invokeSuper(obj, args);
//                log.info("cglib动态代理.......提交事务");
//                return result;
//            } catch (Exception e) {
//                log.error(e.getMessage());
//                log.info("cglib动态代理.......事务回滚");
//                throw e;
//            }
//        };
//        enhancer.setCallback(methodInterceptor);
//
//        return (T) enhancer.create();
//    }
//
//}
