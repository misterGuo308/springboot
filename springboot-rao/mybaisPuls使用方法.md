MybatisPlus官方文档学习mybatisPlus用法
https://mybatis.plus/
github地址
https://github.com/baomidou/mybatis-plus

经测试批量插入的方法不支持事务回滚
/**
 * 插入（批量）
 *
 * @param entityList 实体对象集合
 * @param batchSize  插入批次数量
 */
boolean saveBatch(Collection<T> entityList);
但是该方法支持事务的回滚 个人建议批量时候用下边的方法  批量更新方法同理
/**
 * 插入（批量）
 * 
 * @param entityList 实体对象集合
 * @param batchSize  插入批次数量
 */
boolean saveBatch(Collection<T> entityList, int batchSize);