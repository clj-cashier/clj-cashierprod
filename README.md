# CORE-README

## 项目使用
### 项目启动
1. 命令行形式
    ```bash
    java -Denv=DEV -Dapollo.configService=http://121.43.117.108:8111 -jar xxx.jar
    ```
2. GUI形式


![image.png | left | 747x436](https://cdn.nlark.com/yuque/445/2018/png/119472/1545211130676-97d038b4-bb19-4d39-afbe-993f61929c2c.png "")

### 配置中心使用
#### 项目配置初始化
> 如果项目是第一次创建，那么在运行之前。你还需要在配置中心创建对应的配置项目。具体项目如下
1. 登录配置中心[后台](http://121.43.117.108:8070/)
2. 点击创建项目


![image.png | left | 394x176](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209081834-216eced0-ec37-49c9-a9d6-7d4d9fa7099d.png "")


1. 填写项目信息

![image.png | left | 719x330](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209187482-3471a3bc-7a37-40c7-ab5f-4a6ab44661cd.png "")

    
    1. 部门：为对应的技术部门
    2. 应用ID：为此{项目名称-service}
    3. 应用名称：此项目的中文描述
    4. 应用负责人：此项目 OWNER
    5. 项目管理员：此项目 OWNER
    6. 点击项目配置的文本 TAB，并点击修改按钮
        

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209202560-517ddaa5-8977-4d55-b312-66cff869b363.png "")

2. <span data-type="color" style="color:#F5222D">修改与替换项目相关配置</span>并复制到文本框中，点击提交修改
```
# dubbo 配置
dubbo.application.id = ${projectName}
dubbo.application.name = ${projectName}
dubbo.application.owner = apricot
dubbo.protocol.id = dubbo
dubbo.protocol.name = dubbo

```



![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209219080-b172037a-4d6f-4604-86cb-4094c5885800.png "")


1. 点击发布



![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209243630-034fee9d-8a95-42b0-921a-3822182aef8b.png "")


3. 关联公共空间
> 有一些项目公共的配置提取到了公共空间，其它项目只要关联到这个空间就可以使用他的配置了


![image.png | left | 596x364](https://cdn.nlark.com/yuque/445/2018/png/119472/1545220247217-bb8eb54d-71b9-4d6a-ae03-31bc2d2d77e4.png "")



![image.png | left | 747x463](https://cdn.nlark.com/yuque/445/2018/png/119472/1545220221058-a5b527dd-f41c-4726-a498-b2b9c98e7876.png "")

#### 配置变更
##### 新增配置
1. 点击新增配置



![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209265478-38737423-9f34-41dd-a1eb-2f66d16e1443.png "")


1. 填写配置
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209287449-a433c2cc-16c4-4e53-b6cc-d7c935cd269f.png "")


##### 修改配置
1. 点击要修改配置的修改按钮
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209304692-e3a26b2e-72fc-4c03-a3b1-142366ec8c5a.png "")

2. 修改配置
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209324859-16168af4-f675-4816-be99-6b66961647a7.png "")


##### 发布配置
1. 如果有修改会有修改提示
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209336391-e398c162-b00f-4f26-9822-d3edfb77e701.png "")

2. 点击发布



![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209344168-89ca81d9-1211-4e87-ab4f-e4748cde264f.png "")


#### 批量修改配置
> 上面的变更配置需要一个一个变更，如果需要批量添加或修改，可以通过文本模式修改
1. 点击文本 TAB
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209355659-59c6e19e-9fd5-4ab1-a660-961dd70ebf4c.png "")

2. 点击修改配置按钮
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209365929-c5aaa6d4-850a-4246-8ecc-bac5b920f3a3.png "")

3. 在文本框中编辑配置
4. 提交修改



![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209376105-e1591ffa-9da1-4947-86b5-d15a3ec965aa.png "")


#### 同步配置
> 因为多环境之间可能大部分配置是一样的，手动添加会有大量重复劳动。可以通过同步配置功能。
1. 点击同步配置按钮
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209385998-77a1b3df-0ab2-48f0-9cbf-2e7ca0f17fdc.png "")

2. 选择同步的环境，要同步的配置，下一步
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209396152-70f58fc3-68c1-4116-a98c-4607871a8e8b.png "")

3. 点击同步
    

![image | left](https://cdn.nlark.com/yuque/445/2018/png/119472/1545209404171-d4f5f5ba-640e-4f13-af81-e8e99e8abebc.png "")

4. 切到环境，点击发布

#### 外部文档
[Apollo Java 客户端使用指南](https://github.com/ctripcorp/apollo/wiki/Java%E5%AE%A2%E6%88%B7%E7%AB%AF%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%97)
